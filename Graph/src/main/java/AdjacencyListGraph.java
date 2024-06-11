import java.util.*;

public class AdjacencyListGraph {

    public List<List<Integer>> printGraph(int V, int edges[][]) {

        //in input we have given edges
        List<List<Integer>> graph = new ArrayList<>(V+1);
        for (int i = 0; i < V; i++) {
            graph.set(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;

    }

    //TC -> O(E)
    //SC -> O(2E) an edge is associated with two nodes
    //if E is n then we can say that both TC and SC is O(n)
}
