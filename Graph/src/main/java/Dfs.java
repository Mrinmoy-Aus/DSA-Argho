import java.util.*;

public class Dfs {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfsTraversal(0, visited, adj, dfs);
        return dfs;
    }

    private void dfsTraversal(int sn, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> dfs) {
        visited[sn] = true;//O(1)
        dfs.add(sn);
        for (int nbr : graph.get(sn)) {//o(d)
            if (!visited[nbr]) {
                dfsTraversal(nbr, visited, graph, dfs);
            }
        }
    }

    //TC -> FOR ONE LEVEL O(1)+O(D)
    //total level will be V so o(V+E)
    //SC -> O(V)
}
