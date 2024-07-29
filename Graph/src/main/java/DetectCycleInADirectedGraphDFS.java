import java.util.ArrayList;

public class DetectCycleInADirectedGraphDFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(-1, i, visited, adj)) return true;
            }
        }
        return false;
    }

    //if any of its nbr's other than its parent is visited then it has a cycle

    private boolean dfs(int parent, int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = true;

        for (int nbr : adj.get(src)) {
            if (!visited[nbr]) {
                if (dfs(src, nbr, visited, adj)) return true;
            } else if (nbr != parent) return true;
        }
        return false;
    }

    //TC = O(V+E) and SC O(V)
}
