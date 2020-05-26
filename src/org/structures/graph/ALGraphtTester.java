package org.structures.graph;

public class ALGraphtTester {
    
    public static void main(String[] args) {
        String[] init_vertices = {"A", "B", "C", "D"};
        System.out.println("无向图测试");
        //输入边：{0, 1}, {0, 2}, {1, 3}, {2, 3}
        GraphInterface<String> graph = new ALGraph<>(init_vertices, init_vertices.length, 4);
        System.out.println("深度优先遍历结果：");
        graph.DFS(0);
        System.out.println("广度优先遍历结果：");
        graph.BFS(0);
    }

}
