package org.structures.graph;

public class EdgeArrayTester {
    
    public static void main(String[] args) {
        EdgeArray<String> array = new EdgeArray<>();
        EdgeArrayNode node0 = new EdgeArrayNode(1, 4, 12);
        EdgeArrayNode node1 = new EdgeArrayNode(2, 3, 17);
        EdgeArrayNode node2 = new EdgeArrayNode(0, 5, 19);
        EdgeArrayNode node3 = new EdgeArrayNode(2, 5, 25);
        EdgeArrayNode node4 = new EdgeArrayNode(3, 5, 25);
        EdgeArrayNode node5 = new EdgeArrayNode(4, 5, 26);
        EdgeArrayNode node6 = new EdgeArrayNode(0, 1, 34);
        EdgeArrayNode node7 = new EdgeArrayNode(3, 4, 38);
        EdgeArrayNode node8 = new EdgeArrayNode(0, 2, 46);
        EdgeArrayNode[] nodeList = {node0, node1, node2, node3,
                node4, node5, node6, node7, node8};
        String[] vertices = {"v0", "v1", "v2", "v3", "v4", "v5"};
        int edge_num = 9;
        array.vertices_num = 6;
        array.edge_num = edge_num;
        array.vertices = vertices;
        array.edgeArray = nodeList;
        array.kruskal();
    }

}
