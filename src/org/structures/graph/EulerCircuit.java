package org.structures.graph;

public class EulerCircuit {

    //定义二维数组实现图储存
    int[][] mat;

    //定义顶点个数
    int vertexNum;

    //构造函数问题初始化
    public EulerCircuit(int[][] mat, int vertexNum) {
        super();
        this.mat = mat;
        this.vertexNum = vertexNum;
    }
    
    public int getOddVertexNum() {
        //累加器记录奇数顶点个数
        int count = 0;
        //依次累加每一行元素
        for (int i = 0; i < vertexNum; i++) {
            //记录通过顶点i的边数
            int degree = 0;
            for (int j = 0; j < vertexNum; j++) {
                degree += mat[i][j];
            }
            //顶点度为奇数时
            if (degree % 2 != 0) {
                count++;
            }
        }
        //结束函数，返回奇数顶点个数
        return count;
    }
    
    public static void main(String[] args) {
        //七桥问题数组
        int[][] mat = {{0, 1, 2, 2}, {1, 0, 1, 1}, {2, 1, 0, 0}, {2, 1, 0, 0}};
        //生成EulerCircuit对象
        EulerCircuit eulerCircuit = new EulerCircuit(mat, 4);
        //根据函数获取奇数桥的个数
        int oddVertexNum = eulerCircuit.getOddVertexNum();
        //欧拉路是2;欧拉回路是0
        if (oddVertexNum >= 0) {
            System.out.println("有" + oddVertexNum + "个顶点通奇数桥，无欧拉回路");
        } else {
            System.out.println("有欧拉回路");
        }
    }

}
