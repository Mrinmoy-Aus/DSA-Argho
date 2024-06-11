import java.util.*;
public class AdjacencyMatrix {

    public int[][] printGraph(int V, int edges[][]) {

        int[][] graph = new int[V+1][V+1];

        for(int i =0 ; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        return graph;
    }

    //TC -> O(E)
    //SC -> O(V^2)
    //if E=V=N then TC -> O(N) and SC -> O(N^2)
    //Limitation if V is in the range of 10^5 then we can not use the graph
}
