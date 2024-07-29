import java.util.*;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int comp = 0;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);//Total edges in the comp o(TD)
                comp++;//o(1)
            }
        }
        return comp;
    }

    private void dfs(int src, boolean[] visited, int[][] graph) {
        visited[src] = true;
        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] == 1 && !visited[i]) {
                dfs(i, visited, graph);
            }
        }
    }
    //TC -> O(1) + O(TD OF COMPOnent) -> o(v) + o(TD of graph) -> o(v+e)
    //SC -> O(V)
}
