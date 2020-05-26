package org.structures.graph;

public interface GraphInterface<T> {
    
    /**
     * 图的深度优先遍历
     * @param startIndex
     */
    void DFS(int startIndex);
    
    /**
     * 图的广度优先遍历
     * @param startIndex
     */
    void BFS(int startIndex);

}
