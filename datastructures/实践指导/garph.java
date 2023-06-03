package 实践指导;

public class garph {
    // 邻接矩阵表示的有向图中序号为num的顶点的入度和出度数
    public int indegree(int num){
        int n = this.vertexcount(); // 顶点数
        int degree = 0;
        for (int j = 0; j < n; j++) {
            // 第i列上各元素之和是顶点vi的入度
            if (num != j && this.adjmatrix[j][num] != MAX_WEIGHT){
                degree++;
            }
        }
        return degree;
    }

    public int outdegree(int num){
        int n = this.vertexcount(); // 顶点数
        int degree = 0;
        for (int j = 0; j < n; j++) {
            // 第i列上各元素之和是顶点vi的入度
            if (num != j && this.adjmatrix[num][j] != MAX_WEIGHT){
                degree++;
            }
        }
        return degree;
    }

    // 判断两个顶点是否相通
    public boolean judgeconnect(int i, int j){
        boolean[] visited = new boolean[this.vertexcount]; // 顶点数
        this.dfs(i,visited);// 深度搜索
        if (!visited[j]) return false;
        else return true;
    }

}
