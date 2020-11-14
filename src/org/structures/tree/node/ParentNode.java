package org.structures.tree.node;

public class ParentNode<T> {
    
    /**
     * 泛型结点数据域
     */
    private T data;
    
    /**
     * 结点双亲下标
     */
    private int parent;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

}
