package org.structures.graph;

public class MGraphTester {
    
    public static void main(String[] args) {
        String[] init_vertices = {"A", "B", "C", "D"};
        System.out.println("无向图测试");
        //输入边：{0, 1}, {0, 2}, {1, 3}, {2, 3} √
        //输入边：{0, 1}, {0, 2}, {0, 3}, {3, 1}
        //GraphInterface<String> graph = new MGraph<>(init_vertices, init_vertices.length, 4);
        MGraph<String> graph = new MGraph<>(init_vertices, init_vertices.length, 4);
        System.out.println("深度优先遍历结果：");
        graph.DFS(0);
        System.out.println("广度优先遍历结果：");
        graph.BFS(0);
        
        final int INF = Integer.MAX_VALUE;
        int[][] matrix = new int[][] {
            {0, 4, 3, INF, INF},
            {4, 0, 8, 7, INF},
            {3, 8, 0, INF, 1},
            {INF, 7, INF, 0, 9},
            {INF, INF, 1, 9, 0}
        };
        System.out.println("Prim算法最小生成树：");
        graph.prim(0, matrix);
        //graph.dijkstra(1);
        //graph.floyd();
    }

}
