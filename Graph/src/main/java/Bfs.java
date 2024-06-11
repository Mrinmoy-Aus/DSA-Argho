import java.util.*;

public class Bfs {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] =true;
        queue.add(0);
        while(!queue.isEmpty()){
            int front = queue.poll();// o(1)
            bfs.add(front); // o(1)
            for(int nbr : adj.get(front)){ //O(D)
                if(!visited[nbr]){
                    visited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
        return bfs;
    }

    //TC ->
    // O(1) + o(d) -> one level
    //this will be repeated V times so TC -> O(V) + O(2E) -> O(V+E)
    //sum of all degree is equal to 2E because an Edge is associated with two nodes
    //SC -> O(V) + O(V) -> QUEUE + VISITED

}
