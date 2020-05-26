package org.structures.graph;

/**
 * 边表结点
 */
public class OrthogonalEdgeNode {
    
    /**
     * 弧的终点（弧尾）在顶点表中的下标
     */
    private int tailVex;
    
    /**
     * 弧的起点（弧头）在顶点表中的下标
     */
    private int headVex;

    /**
     * 入边表引用域，引用终点相同的下一条边
     */
    private OrthogonalEdgeNode tailLink;
    
    /**
     * 出边表引用域，引用起点相同的下一条边
     */
    private OrthogonalEdgeNode headLink;

    public OrthogonalEdgeNode(int tailVex, int headVex) {
        super();
        this.tailVex = tailVex;
        this.headVex = headVex;
    }

    public int getTailVex() {
        return tailVex;
    }

    public void setTailVex(int tailVex) {
        this.tailVex = tailVex;
    }

    public int getHeadVex() {
        return headVex;
    }

    public void setHeadVex(int headVex) {
        this.headVex = headVex;
    }

    public OrthogonalEdgeNode getTailLink() {
        return tailLink;
    }

    public void setTailLink(OrthogonalEdgeNode tailLink) {
        this.tailLink = tailLink;
    }

    public OrthogonalEdgeNode getHeadLink() {
        return headLink;
    }

    public void setHeadLink(OrthogonalEdgeNode headLink) {
        this.headLink = headLink;
    }

}
