package org.structures.graph;

/**
 * 顶点表结点
 * @param <T>
 */
public class AdjacencyMultiVertexNode<T> {
    
    /**
     * 数据域
     * 存储顶点数据信息
     */
    private T vertex;
    
    /**
     * 边表头引用
     * 引用依附于该顶点的第一条边的边表结点
     */
    private AdjacencyMultiEdgeNode first;

    public AdjacencyMultiVertexNode() {
        super();
        this.vertex = null;
        this.first = null;
    }

    public AdjacencyMultiVertexNode(T vertex) {
        super();
        this.vertex = vertex;
        this.first = null;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public AdjacencyMultiEdgeNode getFirst() {
        return first;
    }

    public void setFirst(AdjacencyMultiEdgeNode first) {
        this.first = first;
    }

}
