package org.structures.tree.avl;

import java.util.LinkedList;
import java.util.Queue;

import org.structures.stack.SequentialStack;
import org.structures.stack.StackInterface;

public class AvlTree<T extends Comparable<? super T>> implements IAvlTree<T> {
    
    private AvlNode<T> root;
    
    public AvlTree() {
        this.root = null;
    }
    
    public AvlTree(T[] prelist) {
        this.root = create(prelist);
    }
    
    public AvlTree(AvlNode<T> root) {
        this.root = root;
    }
    
    /**
     * 从i开始的表明空子树的先根序列，创建一个以prelist[i]为根的子树，返回根结点，递归方法
     */
    private int i;
    
    private AvlNode<T> create(T[] prelist) {
        AvlNode<T> p = null;
        if (i < prelist.length) {
            T element = prelist[i];
            i++;
            if (element != null) {
                p = new AvlNode<T>(element);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }
    
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int size() {
        return addSize(root);
    }
    
    private int addSize(AvlNode<T> node) {
        int count = 0;
        if (node != null) {
            count++;
            count += addSize(node.left);
            count += addSize(node.right);
        }
        return count;
    }

    @Override
    public int height() {
        AvlNode<T> p = this.root;
        if (p == null) {
            return 0;
        }
        return getHeight(0, p);
    }
    
    private int getHeight(int height, AvlNode<T> node) {
        AvlNode<T> left = node.left;
        AvlNode<T> right = node.right;
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
                return leftResult >= rightResult ? leftResult : rightResult;
            }
        }
    }

    @Override
    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }
    
    private void preOrder(AvlNode<T> p) {
        if (p != null) {
            System.out.print(p + " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }
    
    /**
     * 非递归前序遍历
     */
    public void iteratorPreOrder() {
        //顺序栈初始化
        StackInterface<AvlNode<T>> stack = new SequentialStack<>();
        //工作节点node初始化
        AvlNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                //打印结点
                System.out.print(node + " ");
                //node入栈
                stack.push(node);
                //准备遍历node左孩子
                node = node.left;
            }
            //node为空，栈非空
            if (!stack.isEmpty()) {
                //栈顶元素出栈，赋予node
                node = stack.pop();
                //准备遍历node的右孩子
                node = node.right;
            }
        }
        System.out.println();
    }

    @Override
    public void inOrder() {
        inOrder(this.root);
        System.out.println();
    }
    
    private void inOrder(AvlNode<T> p) {
        if (p != null) {
            inOrder(p.left);
            System.out.print(p + " ");
            inOrder(p.right);
        }
    }
    
    /**
     * 非递归中序遍历
     * 只需将前序遍历的打印语句移到 node = stack.pop()语句之后
     */
    public void iteratorInOrder() {
        //顺序栈初始化
        StackInterface<AvlNode<T>> stack = new SequentialStack<>();
        //工作节点node初始化
        AvlNode<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                //node入栈
                stack.push(node);
                //准备遍历node左孩子
                node = node.left;
            }
            //node为空，栈非空
            if (!stack.isEmpty()) {
                //栈顶元素出栈，赋予node
                node = stack.pop();
                //打印结点
                System.out.print(node + " ");
                //准备遍历node的右孩子
                node = node.right;
            }
        }
        System.out.println();
    }

    @Override
    public void postOrder() {
        postOrder(this.root);
        System.out.println();
    }
    
    private void postOrder(AvlNode<T> p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p + " ");
        }
    }
    
    class FlagBinaryNode {
        /**
         * 定义BinaryTreeNode类型结点
         */
        private AvlNode<T> node;
        /**
         * 定义flag标识符
         */
        private int flag;
        
        public FlagBinaryNode(AvlNode<T> node, int flag) {
            super();
            this.node = node;
            this.flag = flag;
        }
        public AvlNode<T> getNode() {
            return node;
        }
        public void setNode(AvlNode<T> node) {
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
        AvlNode<T> node = root;
        FlagBinaryNode flagNode;
        while (node != null || !stack.isEmpty()) {
            //当前结点非空
            while(node != null) {
                //生成新结点，flag赋值为1
                flagNode = new FlagBinaryNode(node, 1);
                //新结点入栈
                stack.push(flagNode);
                //准备遍历结点左孩子
                node = node.left;
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
                node = flagNode.getNode().right;
            }
        }
        System.out.println();
    }

    @Override
    public void levelOrder() {
        Queue<AvlNode<T>> queue = new LinkedList<>();
        AvlNode<T> p = this.root;
        while(p != null) {
            System.out.print(p + " ");
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right!= null) {
                queue.add(p.right);
            }
            p = queue.poll();
        }
        System.out.println();
    }

    @Override
    public AvlNode<T> insert(T x) {
        this.root = new AvlNode<T>(x, this.root, null);
        this.insert(x, root);
        return this.root;
    }

    @Override
    public AvlNode<T> insert(AvlNode<T> parent, T x, boolean leftChild) {
        if (x == null) {
            return null;
        } else if (leftChild) {
            parent.left = new AvlNode<T>(x, parent.left, null);
            return parent.left;
        }
        parent.right = new AvlNode<T>(x, null, parent.right);
        return parent.right;
    }

    @Override
    public void remove(AvlNode<T> parent, boolean leftChild) {
        if (leftChild) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public AvlNode<T> search(T key) {
        SearchNode node = searchAll(key);
        if (node == null) {
            return null;
        }
        return node.getNode();
    }

    @Override
    public boolean contains(T key) {
        if (search(key) == null) {
            return false;
        }
        return true;
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
        
        private int level;
        
        private AvlNode<T> node;
        
        public SearchNode(int level, AvlNode<T> node) {
            super();
            this.level = level;
            this.node = node;
        }
        
        public int getLevel() {
            return level;
        }
        
        public AvlNode<T> getNode() {
            return node;
        }
    
    }
    
    private SearchNode searchAll(T key) {
        if (key == null || root == null) {
            return null;
        }
        Queue<SearchNode> queue = new LinkedList<>();
        SearchNode rootNode = new SearchNode(0, this.root);
        if (key.equals(root.element)) {
            return rootNode;
        }
        while(rootNode != null && rootNode.getNode() != null) {
            AvlNode<T> treeNode = rootNode.getNode();
            int level = rootNode.getLevel();
            AvlNode<T> left = treeNode.left;
            AvlNode<T> right = treeNode.right;
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
            } else if (key.equals(rootNode.getNode().element)) {
                return rootNode;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return toString(this.root);
    }
    
    private String toString(AvlNode<T> p) {
        if (p == null) {
            return "Λ";
        }
        return p.element.toString() + " " + toString(p.left) + " " + p.right;
    }
    
    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.height;
    }
    
    private AvlNode<T> insert(T data, AvlNode<T> node) {
        if (node == null) {
            return new AvlNode<>(data, null, null);
        }
        int compareResult = data.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(data, node.left);
        } else if (compareResult > 0) {
            node.right = insert(data, node.right);
        } else {
            //Duplicate; do nothing.
            ;
        }
        return balance(node);
    }
    
    private static final int ALLOWED_IMBALANCE = 1;
    
    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) {
            return node;
        } else if (height(node.left)-height(node.right) > ALLOWED_IMBALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.right)-height(node.left) > ALLOWED_IMBALANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }
    
    private AvlNode<T> doubleWithRightChild(AvlNode<T> node) {
        AvlNode<T> right = node.right;
        node.right = right.left;
        right.left = node;
        node.height = Math.max(height(node.right), height(node.left))+1;
        right.height = Math.max(height(right.right), node.height)+1;
        return right;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> node) {
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node) {
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node) {
        AvlNode<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = Math.max(height(node.left), height(node.right))+1;
        left.height = Math.max(height(left.left), node.height)+1;
        return left;
    }

    @SuppressWarnings("unused")
    private AvlNode<T> remove(T data, AvlNode<T> node) {
        if (node == null) {
            //Item not found; do nothing.
            return node;
        }
        int compareResult = data.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(data, node.left);
        } else if (compareResult > 0) {
            node.right = remove(data, node.right);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return balance(node);
    }
    
    private AvlNode<T> findMin(AvlNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    public AvlNode<T> getRoot() {
        return this.root;
    }

}
