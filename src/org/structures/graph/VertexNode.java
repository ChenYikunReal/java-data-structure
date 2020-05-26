package org.structures.graph;

/**
 * 顶点表结点
 * @param <T>
 */
public class VertexNode<T> {
    
    /**
     * 定义泛型数据域
     */
    private T vertex;
    
    /**
     * 定义第一顶点引用域
     */
    private EdgeNode first;

    public VertexNode() {
        super();
        this.vertex = null;
        this.first = null;
    }

    public VertexNode(T vertex) {
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

    public EdgeNode getFirst() {
        return first;
    }

    public void setFirst(EdgeNode first) {
        this.first = first;
    }

}
