package graph;

import java.util.List;

public class Vertex {
    String name;
    List<Edge> edges;

    boolean visited; // 是否被访问过

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
