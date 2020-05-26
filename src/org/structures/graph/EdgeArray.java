package org.structures.graph;

public class EdgeArray<T> {
    
    /**
     * 顶点个数
     */
    protected int vertices_num;
    
    /**
     * 边个数
     */
    protected int edge_num;
    
    /**
     * 图结点
     */
    protected T[] vertices;
    
    /**
     * 边集数组
     */
    protected EdgeArrayNode[] edgeArray;
    
    public void kruskal() {
        int vertex1_root, vertex2_root;
        //定义parent数组
        int parent[] = new int[vertices_num];
        //初始化parent数组
        for (int i = 0; i < vertices_num; i++) {
            parent[i] = -1;
        }
        //依次考察每一条边
        for (int i = 0, num = 0; i < edge_num; i++) {
            EdgeArrayNode node = edgeArray[i];
            vertex1_root = findRoot(parent, node.getFrom());
            vertex2_root = findRoot(parent, node.getTo());
            //位于不同连通分量
            if (vertex1_root != vertex2_root) {
                System.out.println("生成树第" + (num+1) + "条边：" + 
                        vertices[node.getFrom()] + "--" +
                        vertices[node.getTo()] + " : " + node.getWeight());
                parent[vertex2_root] = vertex1_root;
                num++;
            }
        }
    }
    
    /**
     * 求vertex_index的根
     * @param parent
     * @param vertex_index
     * @return
     */
    private int findRoot(int[] parent, int vertex_index) {
        int root = vertex_index;
        while (parent[root] > -1) {
            root = parent[root];
        }
        return root;
    }

}
