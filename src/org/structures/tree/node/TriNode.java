package org.structures.tree.node;

import org.structures.tree.binary.BinaryTreeNode;

public class TriNode<T> {
    
    private T data;
    
    private BinaryTreeNode<T> left;
    
    private BinaryTreeNode<T> right;
    
    private BinaryTreeNode<T> parent;

    public TriNode(T data) {
        super();
        this.data = data;
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

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

}
