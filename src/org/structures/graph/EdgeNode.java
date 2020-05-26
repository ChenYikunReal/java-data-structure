package org.structures.graph;

/**
 * 边表结点
 */
public class EdgeNode {
    
    /**
     * 定义整形临界点域
     */
    private int adjvex;
    
    /**
     * 定义结点后继引用域
     */
    private EdgeNode next;

    public EdgeNode(int adjvex) {
        super();
        this.adjvex = adjvex;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }

}
