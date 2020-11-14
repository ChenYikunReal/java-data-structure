package org.structures.tree.binary;

public class BinaryTreeNode<T> {
    
    private T data;
    
    private BinaryTreeNode<T> left;
    
    private BinaryTreeNode<T> right;
    
    public BinaryTreeNode(T data) {
        super();
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode [data=" + data + "]";
    }
    
    /**
     * 是否是叶子结点
     * @return
     */
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    
}
