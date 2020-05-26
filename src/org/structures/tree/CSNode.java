package org.structures.tree;

public class CSNode<T> {
    
    /**
     * 定义结点泛型数据域
     */
    private T data;
    
    /**
     * 引用长子
     */
    private ChildNode firstChild;
    
    /**
     * 引用右兄弟
     */
    private ChildNode rightSib;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ChildNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(ChildNode firstChild) {
        this.firstChild = firstChild;
    }

    public ChildNode getRightSib() {
        return rightSib;
    }

    public void setRightSib(ChildNode rightSib) {
        this.rightSib = rightSib;
    }

}
