package org.structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.structures.queue.QueueInterface;
import org.structures.queue.circular.CircularQueue;

/**
 * 图的邻接矩阵表示
 * @param <T>
 */
public class MGraph<T> implements GraphInterface<T> {
    
    /**
     * 图的顶点数
     */
    protected int vertices_num;
    
    /**
     * 图的边数
     */
    protected int edge_num;
    
    /**
     * 一维数组储存图的顶点
     */
    protected T[] vertices;
    
    /**
     * 二维数组实现邻接矩阵
     */
    protected int[][] adjMatrix;
    
    /**
     * 访问标志数组s
     */
    boolean[] visited;
    
    @SuppressWarnings("unchecked")
    public MGraph(T[] init_vertices, int n, int e) {
        if (n == 0) {
            throw new GraphException("无顶点，图构造失败");
        }
        //初始化顶点个数
        this.vertices_num = n;
        //初始化边个数
        this.edge_num = e;
        //定义顶点数组
        this.vertices = (T[]) new Object[vertices_num];
        //邻接矩阵分配空间
        this.adjMatrix = new int[vertices_num][vertices_num];
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            //初始化顶点数组
            vertices[i] = init_vertices[i];
        }
        //初始化邻接矩阵
        if (edge_num > 0) {
//            for (int j = 1; j <= e; j++) {
//                System.out.println("输入第" + j + "条边第1个顶点的信息");
//                int vertex1 = reader.nextInt();
//                System.out.println("输入第" + j + "条边第2个顶点的信息");
//                int vertex2 = reader.nextInt();
//                adjMatrix[vertex1][vertex2] = 1;
//                adjMatrix[vertex2][vertex1] = 1;
//            }
            adjMatrix[0][1] = 1;
            adjMatrix[1][0] = 1;
            adjMatrix[0][2] = 1;
            adjMatrix[2][0] = 1;
            adjMatrix[1][3] = 1;
            adjMatrix[3][1] = 1;
            adjMatrix[2][3] = 1;
            adjMatrix[3][2] = 1;
        }
        reader.close();
    }

    /**
     * 深度优先遍历递归算法
     * O(N^2)
     * @param startIndex
     */
    @Override
    public void DFS(int startIndex) {
        //初始化访问标志数组
        visited = new boolean[vertices_num];
        iteratorDFS(startIndex);
        System.out.println();
    }

    /**
     * 深度优先遍历递归算法
     * O(N^2)
     * @param startIndex
     */
    private void iteratorDFS(int startIndex) {
        //输出访问结点
        System.out.print(vertices[startIndex].toString() + " ");
        //标识顶点已被访问过
        visited[startIndex] = true;
        for (int i = 0; i < vertices_num; i++) {
            if (adjMatrix[startIndex][i] == 1 && !visited[i]) {
                iteratorDFS(i);
            }
        }
    }

    /**
     * 广度遍历算法
     * O(N^2)
     */
    @Override
    public void BFS(int startIndex) {
        //初始化访问标志数组
        visited = new boolean[vertices_num];
        //工作队列初始化
        QueueInterface<Integer> queue = new CircularQueue<>();
        //临时变量，储存出队顶点编号
        int front_vertex;
        //输出访问结点
        System.out.print(vertices[startIndex].toString() + " ");
        //标识结点已被访问
        visited[startIndex] = true;
        //被访问过的顶点编号入队
        queue.enQueue(startIndex);;
        while(!queue.isEmpty()) {
            //队头顶点编号出队
            front_vertex = queue.deQueue();
            for (int i = 0; i < vertices_num; i++) {
                if (adjMatrix[front_vertex][i] == 1 && !visited[i]) {
                    System.out.print(vertices[i].toString() + " ");
                    visited[i] = true;
                    queue.enQueue(i);
                }
            }
        }
        System.out.println();
    }
    
    public void prim(int fromIndex, int[][] matrix) {
        final int INF = Integer.MAX_VALUE;
        List<Integer> reachedVertexList = new ArrayList<>();
        //选择顶点startIndex为初始顶点，放入已触达顶点集合中
        reachedVertexList.add(fromIndex);
        //创建最小生成树数组，首元素设为-1
        int[] parents = new int[matrix.length];
        parents[0] = -1;
        //边的权重
        int weight;
        //出发点是fromIndex
        //目标顶点下标
        int toIndex = fromIndex;
        while (reachedVertexList.size() < matrix.length) {
            weight = INF;
            //在已触达的顶点中，寻找到达新顶点的最短边
            for (Integer vertexIndex : reachedVertexList) {
                for (int i = 0; i < matrix.length; i++) {
                    if (!reachedVertexList.contains(i)) {
                        if (matrix[vertexIndex][i] < weight) {
                            fromIndex = vertexIndex;
                            toIndex = i;
                            weight = matrix[vertexIndex][i];
                        }
                    }
                }
            }
            //确定了权值最小的目标顶点，放入已触达顶点集合
            reachedVertexList.add(toIndex);
            //放入最小生成树的数组
            parents[toIndex] = fromIndex;
        }
        for (int parent : parents) {
            System.out.print(parent + " ");
        }
        System.out.println();
    }
    
    /**
     * 在数组中查找最小权重并返回其下标
     * @param lowest
     * @return
     */
    private int getMin(int[] lowest) {
        if (lowest.length == 0) {
            return -1;
        }
        int min = lowest[0];
        int index = 0;
        for (int i = 1; i < lowest.length; i++) {
            if (lowest[i] < min) {
                min = lowest[i];
                index = i;
            }
        }
        return index;
    }
    
    /**
     * Dijkstra算法
     * @param startIndex
     */
    public void dijkstra(int startIndex) {
        //数组dist，储存各顶点到源点的距离
        int[] dist = new int[vertices_num];
        //数组path，储存各顶点到源点路径
        String[] path = new String[vertices_num];
        //记录dist中最短边对应顶点
        int minEdge;
        //初始化dist、path
        for (int i = 0; i < vertices_num; i++) {
            dist[i] = adjMatrix[startIndex][i];
            if (dist[i] != -1) {
                path[i] = vertices[startIndex] + " " + vertices[i];
            } else {
                path[i] = "";
            }
        }
        for (int num = 1; num < vertices_num; num++) {
            //
            minEdge = getMin(dist);
            System.out.println("源点" + vertices[startIndex] + 
                    "到顶点" + path[minEdge] + " " + dist[minEdge]);
            for (int i = 0; i < vertices_num; i++) {        //更新数组dist、path
                if (adjMatrix[minEdge][i] != -1 && 
                        (dist[i] == -1 || dist[i] > dist[minEdge]+adjMatrix[minEdge][i])) {
                    dist[i] = dist[minEdge] + adjMatrix[minEdge][i];
                    path[i] = path[minEdge] + " " + vertices[i];
                }
            }
            //顶点minEdge加入集合
            dist[minEdge] = 0;
        }
    }

    /**
     * Floyd算法
     */
    public void floyd() {
        //数组dist，储存各顶点到源点的距离
        int[][] dist = new int[vertices_num][vertices_num];
        String[][] path = new String[vertices_num][vertices_num];
        for (int i = 0; i < vertices_num; i++) {
            for (int j = 0; j < vertices_num; j++) {
                dist[i][j] = adjMatrix[i][j];
                if (dist[i][j] != -1 && dist[i][j] != 0) {
                    path[i][j] = vertices[i] + " " + vertices[j];
                } else {
                    path[i][j] = "";
                }
            }
        }
        for (int k = 0; k < vertices_num; k++) {
            for (int i = 0; i < vertices_num; i++) {
                for (int j = 0; j < vertices_num; j++) {
                    if (dist[i][k] != -1 && dist[k][j] != -1 && 
                            (dist[i][j] == -1 || dist[i][k]+dist[k][j] < dist[i][j])) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[i][k] + vertices[j];
                    }
                }
            }
        }
    }
    
}
