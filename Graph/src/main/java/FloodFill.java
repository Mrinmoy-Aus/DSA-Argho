import java.util.*;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color, new boolean[image.length][image[0].length]);
        return image;
    }

    private void dfs(int[][] graph, int i, int j, int initialColor, int toColor, boolean[][] visited) {
        visited[i][j] = true;
        graph[i][j] = toColor;
        //loop though the unvisited neighbours with same color and color them
        //check up
        if (i - 1 >= 0 && !visited[i - 1][j] && graph[i - 1][j] == initialColor) {
            dfs(graph, i - 1, j, initialColor, toColor, visited);
        }

        //check down
        if (i + 1 < graph.length && !visited[i + 1][j] && graph[i + 1][j] == initialColor) {
            dfs(graph, i + 1, j, initialColor, toColor, visited);
        }

        //check left
        if (j - 1 >= 0 && !visited[i][j - 1] && graph[i][j - 1] == initialColor) {
            dfs(graph, i, j - 1, initialColor, toColor, visited);
        }

        //check right
        if (j + 1 < graph[0].length && !visited[i][j + 1] && graph[i][j + 1] == initialColor) {
            dfs(graph, i, j + 1, initialColor, toColor, visited);
        }
    }

    //TC -> O(N^2)
    //SC -> O(N^2)
}
