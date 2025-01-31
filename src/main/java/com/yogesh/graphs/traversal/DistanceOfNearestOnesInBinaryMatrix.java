package com.yogesh.graphs.traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestOnesInBinaryMatrix {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] nearestOnes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int i = x + dir[0];
                int j = y + dir[1];

                if (i < 0 || i >= rows || j < 0 || j >= cols) {
                    continue;
                }

                if (dist[x][y] + 1 < dist[i][j]) {
                    dist[i][j] = dist[x][y] + 1;
                    queue.offer(new int[] {i, j});
                }

            }
        }
        return dist;
    }
}
