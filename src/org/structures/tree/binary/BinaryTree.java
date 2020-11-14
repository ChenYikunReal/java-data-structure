package org.structures.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.structures.stack.SequentialStack;
import org.structures.stack.StackInterface;

public class BinaryTree<T> implements IBinaryTree<T> {
    
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        super();
        this.root = null;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        super();
        this.root = root;
    }
    
    public BinaryTree(T[] prelist) {
        this.root = create(prelist);
    }
    
    /**
     * 从i开始的表明空子树的先根序列，创建一个以prelist[i]为根的子树，返回根结点，递归方法
     */
    private int i;
    
    private BinaryTreeNode<T> create(T[] prelist) {
        BinaryTreeNode<T> p = null;
        if (i < prelist.length) {
            T element = prelist[i];
            i++;
            if (element != null) {
                p = new BinaryTreeNode<T>(element);
                p.setLeft(create(prelist));
                p.setRight(create(prelist));
            }
        }
        return p;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int size() {
        return addSize(root);
    }
    
    private int addSize(BinaryTreeNode<T> node) {
        int count = 0;
        if (node != null) {
            count++;
            count += addSize(node.getLeft());
            count += addSize(node.getRight());
        }
        return count;
    }

    @Override
    public int height() {
        BinaryTreeNode<T> p = this.root;
        if (p == null) {
            return 0;
        }
        return getHeight(0, p);
    }
    
    private int getHeight(int height, BinaryTreeNode<T> node) {
        BinaryTreeNode<T> left = node.getLeft();
        BinaryTreeNode<T> right = node.getRight();
        if (left == null) {
            if (right == null) {
                return height;
            } else {
                return getHeight(height+1, right);
            }
        } else {
            if (right == null) {
                return getHeight(height+1, left);
            } else {
                int leftResult = getHeight(height+1, left);
                int rightResult = getHeight(height+1, right);
                return Math.max(leftResult, rightResult);
            }
        }
    }

    @Override
    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }
    
    private void preOrder(BinaryTreeNode<T> p) {
        if (p != null) {
            System.out.print(p + " ");
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }
    
    /**
     * 非递归前序遍历
     */
    public void iteratorPreOrder() {
        //顺序栈初始化
        StackInterface<BinaryTreeNode<T>> stack = new SequentialStack<>();
        //工作节点node初始化
        BinaryTreeNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                //打印结点
                System.out.print(node + " ");
                //node入栈
                stack.push(node);
                //准备遍历node左孩子
                node = node.getLeft();
            }
            //node为空，栈非空
            if (!stack.isEmpty()) {
                //栈顶元素出栈，赋予node
                node = stack.pop();
                //准备遍历node的右孩子
                node = node.getRight();
            }
        }
        System.out.println();
    }

    @Override
    public void inOrder() {
        inOrder(this.root);
        System.out.println();
    }
    
    private void inOrder(BinaryTreeNode<T> p) {
        if (p != null) {
            inOrder(p.getLeft());
            System.out.print(p + " ");
            inOrder(p.getRight());
        }
    }
    
    /**
     * 非递归中序遍历
     * 只需将前序遍历的打印语句移到 node = stack.pop()语句之后
     */
    public void iteratorInOrder() {
        //顺序栈初始化
        StackInterface<BinaryTreeNode<T>> stack = new SequentialStack<>();
        //工作节点node初始化
        BinaryTreeNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                //node入栈
                stack.push(node);
                //准备遍历node左孩子
                node = node.getLeft();
            }
            //node为空，栈非空
            if (!stack.isEmpty()) {
                //栈顶元素出栈，赋予node
                node = stack.pop();
                //打印结点
                System.out.print(node + " ");
                //准备遍历node的右孩子
                node = node.getRight();
            }
        }
        System.out.println();
    }

    @Override
    public void postOrder() {
        postOrder(this.root);
        System.out.println();
    }
    
    private void postOrder(BinaryTreeNode<T> p) {
        if (p != null) {
            postOrder(p.getLeft());
            postOrder(p.getRight());
            System.out.print(p + " ");
        }
    }
    
    class FlagBinaryNode {
        /**
         * 定义BinaryTreeNode类型结点
         */
        private BinaryTreeNode<T> node;
        /**
         * 定义flag标识符
         */
        private int flag;
        
        public FlagBinaryNode(BinaryTreeNode<T> node, int flag) {
            super();
            this.node = node;
            this.flag = flag;
        }
        public BinaryTreeNode<T> getNode() {
            return node;
        }
        public void setNode(BinaryTreeNode<T> node) {
            this.node = node;
        }
        public int getFlag() {
            return flag;
        }
        public void setFlag(int flag) {
            this.flag = flag;
        }
    }
    
    /**
     * 非递归的后序遍历
     */
    public void iteratorPostOrder() {
        //顺序栈初始化
        StackInterface<FlagBinaryNode> stack = new SequentialStack<>();
        //工作节点node初始化
        BinaryTreeNode<T> node = root;
        FlagBinaryNode flagNode;
        while (node != null || !stack.isEmpty()) {
            //当前结点非空
            while(node != null) {
                //生成新结点，flag赋值为1
                flagNode = new FlagBinaryNode(node, 1);
                //新结点入栈
                stack.push(flagNode);
                //准备遍历结点左孩子
                node = node.getLeft();
            }
            //node为空，栈非空
            while (!stack.isEmpty() && (stack.getTop()).getFlag() == 2) {
                //flag为2,，出栈，获取Node
                node = (stack.pop()).getNode();
                //打印元素
                System.out.print(node + " ");
                node = null;
            }
            //栈不为空且flag值为1
            if (!stack.isEmpty()) {
                //出栈
                flagNode = stack.pop();
                //出栈结点flag赋为2
                flagNode.setFlag(2);
                //flag赋值后结点入栈
                stack.push(flagNode);
                //准备遍历结点右子树
                node = flagNode.getNode().getRight();
            }
        }
        System.out.println();
    }

    @Override
    public void levelOrder() {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        BinaryTreeNode<T> p = this.root;
        while(p != null) {
            System.out.print(p + " ");
            if (p.getLeft() != null) {
                queue.add(p.getLeft());
            }
            if (p.getRight() != null) {
                queue.add(p.getRight());
            }
            p = queue.poll();
        }
        System.out.println();
    }

    @Override
    public BinaryTreeNode<T> insert(T x) {
        return this.root = new BinaryTreeNode<T>(x, this.root, null);
    }

    @Override
    public BinaryTreeNode<T> insert(BinaryTreeNode<T> parent, T x, boolean leftChild) {
        if (x == null) {
            return null;
        } else if (leftChild) {
            parent.setLeft(new BinaryTreeNode<T>(x, parent.getLeft(), null));
            return parent.getLeft();
        }
        parent.setRight(new BinaryTreeNode<T>(x, null, parent.getRight()));
        return parent.getRight();
    }

    @Override
    public void remove(BinaryTreeNode<T> parent, boolean leftChild) {
        if (leftChild) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public BinaryTreeNode<T> search(T key) {
        SearchNode node = searchAll(key);
        if (node == null) {
            return null;
        }
        return node.getNode();
    }

    @Override
    public boolean contains(T key) {
        return search(key) != null;
    }

    @Override
    public int level(T key) {
        SearchNode node = searchAll(key);
        if (node == null) {
            return -1;
        }
        return node.getLevel();
    }
    
    private class SearchNode {
        private final int level;
        private final BinaryTreeNode<T> node;
        public SearchNode(int level, BinaryTreeNode<T> node) {
            super();
            this.level = level;
            this.node = node;
        }
        public int getLevel() {
            return level;
        }
        public BinaryTreeNode<T> getNode() {
            return node;
        }
    }
    
    private SearchNode searchAll(T key) {
        if (key == null || root == null) {
            return null;
        }
        Queue<SearchNode> queue = new LinkedList<>();
        SearchNode rootNode = new SearchNode(0, this.root);
        if (key.equals(root.getData())) {
            return rootNode;
        }
        while(rootNode.getNode() != null) {
            BinaryTreeNode<T> treeNode = rootNode.getNode();
            int level = rootNode.getLevel();
            BinaryTreeNode<T> left = treeNode.getLeft();
            BinaryTreeNode<T> right = treeNode.getRight();
            if (left != null) {
                SearchNode leftNode = new SearchNode(level+1, left);
                queue.add(leftNode);
            }
            if (right != null) {
                SearchNode rightNode = new SearchNode(level+1, right);
                queue.add(rightNode);
            }
            rootNode = queue.poll();
            if (rootNode == null) {
                return null;
            } else if (key.equals(rootNode.getNode().getData())) {
                return rootNode;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return toString(this.root);
    }
    
    private String toString(BinaryTreeNode<T> p) {
        if (p == null) {
            return "Λ";
        }
        return p.getData().toString() + " " + toString(p.getLeft()) + " " + p.getRight();
    }

    public int minSizeBetweenTwoNodes(BinaryTreeNode<T> p, BinaryTreeNode<T> q) {
        //建立长度为高、类型为Node的数组
        List<BinaryTreeNode<T>> tempPath = new ArrayList<>();
        //结点p的路径
        List<BinaryTreeNode<T>> pathP = null;
        //结点q的路径
        List<BinaryTreeNode<T>> pathQ = null;
        //深度优先遍历，查找路径
        pathP = minSizeBetweenTwoNodesPre(root, tempPath, p);
        pathQ = minSizeBetweenTwoNodesPre(root, tempPath, q);
        //BinaryTreeNode<T> parent = null;
        for (int i = 0; i < pathP.size(); i++) {
            if (pathP.get(i).equals(q)) {
                return pathP.size()-1-i;
            }
        }
        int pHeight = 0;
        int qHeight = 0;
        outer:
        for (int i = pathP.size(); i > 0; i--) {
            BinaryTreeNode<T> node1 = pathP.get(i);
            for (int j = pathQ.size(); j > 0; j--) {
                BinaryTreeNode<T> node2 = pathQ.get(j);
                if (node1.equals(node2)) {
                    //parent = node1;
                    pHeight = pathP.size()-1-i;
                    qHeight = pathQ.size()-1-j;
                    break outer;
                }
            }
        }
        return pHeight+qHeight;
    }
    
    private List<BinaryTreeNode<T>> minSizeBetweenTwoNodesPre(BinaryTreeNode<T> node,
            List<BinaryTreeNode<T>> tempPath, BinaryTreeNode<T> find) {
        if (node != null) {
            tempPath.add(node);
            if (node.equals(find)) {
                return tempPath;
            }
            List<BinaryTreeNode<T>> left = minSizeBetweenTwoNodesPre(node.getLeft(), tempPath, find);
            if (left != null) {
                return left;
            }
            return minSizeBetweenTwoNodesPre(node.getRight(), tempPath, find);
        } else {
            return null;
        }
    }

}
