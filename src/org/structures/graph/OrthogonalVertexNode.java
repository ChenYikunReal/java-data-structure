package org.structures.graph;

/**
 * 顶点表结点
 * @param <T>
 */
public class OrthogonalVertexNode<T> {
    
    /**
     * 泛型数据域
     * 存放顶点数据信息
     */
    private T vertex;
    
    /**
     * 入边表头引用
     * 引用以该顶点为终点的弧构成的链表中的第一个结点
     */
    private OrthogonalEdgeNode firstIn;
    
    /**
     * 出边表头引用
     * 引用以该顶点为起点的弧构成的链表中的第一个结点
     */
    private OrthogonalEdgeNode firstOut;

    public OrthogonalVertexNode() {
        super();
        this.vertex = null;
        this.firstIn = null;
        this.firstOut = null;
    }

    public OrthogonalVertexNode(T vertex) {
        super();
        this.vertex = vertex;
        this.firstIn = null;
        this.firstOut = null;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public OrthogonalEdgeNode getFirstIn() {
        return firstIn;
    }

    public void setFirstIn(OrthogonalEdgeNode firstIn) {
        this.firstIn = firstIn;
    }

    public OrthogonalEdgeNode getFirstOut() {
        return firstOut;
    }

    public void setFirstOut(OrthogonalEdgeNode firstOut) {
        this.firstOut = firstOut;
    }

}
