package com.yogesh.graphs.traversal;

public class FloodFill {
    /*

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        if (image[sr][sc] == newColor) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColor, m, n);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int newColor, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != color) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i+1, j, color, newColor, m, n);
        dfs(image, i-1, j, color, newColor, m, n);
        dfs(image, i, j+1, color, newColor, m, n);
        dfs(image, i, j-1, color, newColor, m, n);
    }
    */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // If the starting pixel already has the new color, no changes needed
        if (image[sr][sc] == newColor) {
            return image;
        }

        // Get the initial color of the starting pixel
        int oldColor = image[sr][sc];

        // Start the DFS flood fill
        dfs(image, sr, sc, oldColor, newColor);

        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        // Check for boundary conditions or if the pixel is not the target old color
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != oldColor) {
            return;
        }

        // Change the color of the current pixel
        image[x][y] = newColor;

        // Recursively call dfs for the 4 neighboring pixels
        dfs(image, x + 1, y, oldColor, newColor); // down
        dfs(image, x - 1, y, oldColor, newColor); // up
        dfs(image, x, y + 1, oldColor, newColor); // right
        dfs(image, x, y - 1, oldColor, newColor); // left
    }
}
