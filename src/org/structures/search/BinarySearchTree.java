package org.structures.search;

public class BinarySearchTree {
    
    /**
     * 二叉排序树根结点
     */
    protected BinaryTreeNode<Integer> root;
    
    
    public BinarySearchTree(int[] record, int n) {
        for (int i = 0; i < record.length; i++) {
            insertBST(root, record[i]);
        }
    }
    
    public BinaryTreeNode<Integer> searchBST(BinaryTreeNode<Integer> root, Integer key) {
        //root为空，返回空
        if (root == null) {
            return null;
        } else if ((Integer)root.getData() == key.intValue()) {     //key等于根节点，查找成功
            return root;
        } else if ((Integer)root.getData() > key.intValue()) {      //key小于根结点，将在左子树查找
            return searchBST(root.getLeft(), key);
        } else {                                                    //key大于很结点，将在右子树查找
            return searchBST(root.getRight(), key);
        }
    }
    
    public void insertBST(BinaryTreeNode<Integer> newRoot, Integer element) {
        if (newRoot == null) {
            this.root = new BinaryTreeNode<Integer>(element);
        } else {
            if (newRoot.getData().intValue() > element.intValue()) {
                if (newRoot.getLeft() == null) {
                    newRoot.setLeft(new BinaryTreeNode<Integer>(element));
                } else {
                    insertBST(newRoot.getLeft(), element);
                }
            } else {
                if (newRoot.getRight() == null) {
                    newRoot.setRight(new BinaryTreeNode<Integer>(element));
                } else {
                    insertBST(newRoot.getRight(), element);
                }
            }
        }
    }
    
    /**
     * 删除结点是父结点的左儿子
     * @param node
     * @param parent
     */
    public void deleteLeftBST(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent) {
        //左右儿子均不存在
        if (node.getLeft() == null && node.getRight() == null) {
            //删除结点为叶子结点
            parent.setLeft(null);
        } else if (node.getRight() == null) {       //右空，删除结点只有左子树
            parent.setLeft(node.getLeft());
        } else if (node.getLeft() == null) {        //左空，删除结点只有右子树
            parent.setLeft(node.getRight());
        } else {                                    //左右均不空
            BinaryTreeNode<Integer> replaceParent = node;
            BinaryTreeNode<Integer> replaceNode = node.getRight();
            //将replaceNode沿着左分支下移，直到最左下结点->查找删除结点的右孩子的最左下结点
            //node.getRight()经过排空，是安全的的，不会爆空指针
            while (replaceNode.getLeft() != null) {
                replaceParent = replaceNode;
                replaceNode = replaceNode.getLeft();
            }
            //删除结点的数据替换——换成查找到的结点
            node.setData(replaceNode.getData());
            //删除结点右孩子无左子树
            if (replaceParent == node) {
                replaceParent.setRight(replaceNode.getRight());
            } else {        //正常且理想的情况，把右孩子提上来当左孩子
                replaceParent.setLeft(replaceNode.getRight());
            }
        }
    }
    
    /**
     * 删除结点是父结点的右儿子
     * @param node
     * @param parent
     */
    public void deleteRightBST(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent) {
        //左右儿子均不存在
        if (node.getLeft() == null && node.getRight() == null) {
            //删除结点为叶子结点
            parent.setLeft(null);
        } else if (node.getRight() == null) {       //右空，删除结点只有左子树
            parent.setRight(node.getLeft());
        } else if (node.getLeft() == null) {        //左空，删除结点只有右子树
            parent.setRight(node.getRight());
        } else {                                    //左右均不空
            BinaryTreeNode<Integer> replaceParent = node;
            BinaryTreeNode<Integer> replaceNode = node.getLeft();
            while (replaceNode.getRight() != null) {
                replaceParent = replaceNode;
                replaceNode = replaceNode.getRight();
            }
            node.setData(replaceNode.getData());
            if (replaceParent == node) {
                replaceParent.setLeft(replaceNode.getLeft());
            } else {
                replaceParent.setRight(replaceNode.getLeft());
            }
        }
    }

}
