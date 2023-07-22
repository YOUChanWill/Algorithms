package graph;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class DFS {

    private static void dfs(Vertex v){
        v.visited = true;
        System.out.println(v.name);
        for (Edge edge :
                v.edges) {
            if (!edge.linked.visited) {
                dfs(edge.linked);
            }
        }
    }


    // 使用栈结构来实现dfs
    private static void dfs2(Vertex v){
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()){
            Vertex pop = stack.pop();
            pop.visited = true;
            System.out.println(pop.name);
            for (Edge edge :
                    pop.edges) {
                if (!edge.linked.visited){
                    stack.push(edge.linked);
                }
            }
        }
    }



    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");


    }

}
