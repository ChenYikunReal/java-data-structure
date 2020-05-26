package org.structures.heap.disjoint_set;

public class UnionFindNode {
    
    /**
     * 定义结点数据域
     */
    private char element;

    /**
     * 定义结点双亲
     */
    private int parent;

    public UnionFindNode(char element, int parent) {
        super();
        this.element = element;
        this.parent = parent;
    }

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

}
