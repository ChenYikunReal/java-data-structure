package org.structures.graph;

/**
 * 边表结点
 */
public class AdjacencyMultiEdgeNode {
    
    /**
     * 本边依附的结点1在顶点表中的下标
     */
    private int iVex;
    
    /**
     * 本边依附的结点2在顶点表中的下标
     */
    private int jVex;

    /**
     * 引用域，引用依附于顶点iVex的下一条边
     */
    private AdjacencyMultiEdgeNode iNext;
    
    /**
     * 引用域，引用依附于顶点jVex的下一条边
     */
    private AdjacencyMultiEdgeNode jNext;

    public AdjacencyMultiEdgeNode(int iVex, int jVex) {
        super();
        this.iVex = iVex;
        this.jVex = jVex;
    }

    public int getiVex() {
        return iVex;
    }

    public void setiVex(int iVex) {
        this.iVex = iVex;
    }

    public int getjVex() {
        return jVex;
    }

    public void setjVex(int jVex) {
        this.jVex = jVex;
    }

    public AdjacencyMultiEdgeNode getiNext() {
        return iNext;
    }

    public void setiNext(AdjacencyMultiEdgeNode iNext) {
        this.iNext = iNext;
    }

    public AdjacencyMultiEdgeNode getjNext() {
        return jNext;
    }

    public void setjNext(AdjacencyMultiEdgeNode jNext) {
        this.jNext = jNext;
    }

}
