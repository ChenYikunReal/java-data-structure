package org.structures.tree.node;

public class ChildNode {
    
    /**
     * 结点对应头结点下标
     */
    private int child;
    
    /**
     * 引用下一个孩子
     */
    private ChildNode next;

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public ChildNode getNext() {
        return next;
    }

    public void setNext(ChildNode next) {
        this.next = next;
    }

}
