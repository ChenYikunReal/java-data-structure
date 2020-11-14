package org.structures.graph.tangram;

public class Tangram {
    
    private static final int BOARD_NUMBER = 7;
    
    //定义七巧板
    private char[] board = new char[BOARD_NUMBER];
    
    private int[][] edge = new int[BOARD_NUMBER][BOARD_NUMBER];

    //初始化所有顶点均涂色0
    private final int[] color = new int[BOARD_NUMBER];
    
    public Tangram(char[] board, int[][] edge) {
        this.board = board;
        this.edge = edge;
    }
    
    public void colour() {
        int vertex = 0;
        while (vertex < BOARD_NUMBER) {
            int flag = 1;
            color[vertex]++;
            if (color[vertex] > 4) {
                color[vertex] = 0;
                vertex--;
                continue;
            }
            for (int adjVertex = 0; adjVertex < vertex; adjVertex++) {
                if (edge[vertex][adjVertex] == 1 && color[vertex] == color[adjVertex]) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0) {
                continue;
            }
            vertex++;
        }
        for (int i = 0; i < BOARD_NUMBER; i++) {
            System.out.println(board[i] + "涂色为：" + color[i]);
        }
    }
    
    public static void main(String[] args) {
        char[] board = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] edge = new int[][] {{0, 1, 0, 0, 1, 1, 0}, {1, 0, 1, 1, 0, 0, 0},
                                    {0, 1, 0, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 1},
                                    {1, 0, 0, 1, 0, 1, 1}, {1, 0, 0, 0, 1, 0, 0},
                                    {0, 0, 0, 1, 1, 0, 0}};
        Tangram p = new Tangram(board, edge);
        p.colour();
    }

}
