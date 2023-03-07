package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> verexList; // 储存顶点集合
    private int[][] edges; // 储存顶点对应的邻结矩阵
    private int numOfEdges; // 边的数目

    public Graph(int n) {
        // 初始化定点集合和矩阵
        this.verexList = new ArrayList<String>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
    }

    // 打印图
    public void showGraph(){
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    // 返回index对应的顶点数据
    public String getValueByIndex(int index){
        return verexList.get(index);
    }

    // 返回两个index对应的顶点的权值
    public int getWeight(int index1, int index2){
        return edges[index1][index2];
    }

    // 增加顶点
    public void insetVertex(String vertex){
        verexList.add(vertex);
    }

    // 为顶点之间添加边
    public void insertEdges(int index1, int index2, int weight){
        edges[index1][index2] = weight;
        edges[index2][index1] = weight;
        numOfEdges++; // 边的计数
    }
}


class Test{
    public static void main(String[] args) {
        int n = 5;
        String Vertex[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);

        // 添加顶点
        for (String vertex : Vertex) {
            graph.insetVertex(vertex);
        }

        // 建立顶点的连接关系
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.showGraph();


    }
}
