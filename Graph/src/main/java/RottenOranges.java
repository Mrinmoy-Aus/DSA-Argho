import java.awt.*;
import java.util.*;

public class RottenOranges {
    public class Pair {
        int i, j, time;

        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> rottenQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {//TC -> O(N*M)
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 2) {
                    visited[i][j] = true;
                    rottenQueue.add(new Pair(i, j, 0));
                }
            }
        }
        int timeEllapsed = 0;
        while (!rottenQueue.isEmpty()) {//o(n*m)
            Pair front = rottenQueue.poll();
            int i = front.i;
            int j = front.j;
            int time = front.time;
            timeEllapsed = time;
            //check if up is not visited and it is fresh
            if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {//O(1)
                visited[i - 1][j] = true;
                grid[i - 1][j] = 2;
                rottenQueue.add(new Pair(i - 1, j, time + 1));
            }

            //down
            if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 1) {//O(1)
                visited[i + 1][j] = true;
                grid[i + 1][j] = 2;
                rottenQueue.add(new Pair(i + 1, j, time + 1));
            }

            //left
            if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {//o(1)
                visited[i][j - 1] = true;
                grid[i][j - 1] = 2;
                rottenQueue.add(new Pair(i, j - 1, time + 1));
            }

            //right
            if (j + 1 < m && !visited[i][j + 1] && grid[i][j + 1] == 1) {//O(1)
                visited[i][j + 1] = true;
                grid[i][j + 1] = 2;
                rottenQueue.add(new Pair(i, j + 1, time + 1));
            }
        }

        //check if all oranges are rotten
        for (int i = 0; i < n; i++) {//o(n*M)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return timeEllapsed;
    }

    //TC -> O(3n*M) -> o(n*m)
    //SC -> O(N*M)
}
