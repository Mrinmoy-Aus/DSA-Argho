import java.util.*;
public class DetectCycleInADirectedGraph {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[V];
        for(int i =0 ; i<V ; i++){
            if(!visited[i]){
                if(bfs(i,adj,visited)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int src , ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Integer> mq = new ArrayDeque<>();
        mq.add(src);
        while(!mq.isEmpty()){
            int node = mq.remove();
            if(visited[node]) return true;
            visited[node] = true;
            for(int nbr : adj.get(node)){
                if(!visited[nbr]){
                    mq.add(nbr);
                }
            }
        }
        return false;
    }
}
