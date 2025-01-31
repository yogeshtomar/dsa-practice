package com.yogesh.graphs.traversal;

public class NoOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row <  0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}

/**
 * How to Tackle This Question in an Interview
 * 1. Understand the Problem
 * Restate the problem in your own words to confirm understanding.
 *
 * Ask clarifying questions if needed.
 *
 * Clarifications to Ask:
 *
 * Are the grid boundaries surrounded by water? (Yes, assume all edges are water.)
 *
 * Can the grid be empty? (Yes, handle edge cases where the grid is empty.)
 *
 * Are diagonal connections considered part of the same island? (No, only horizontal and vertical connections.)
 *
 * What is the expected output if there are no islands? (Return 0.)
 *
 * 2. Break Down the Problem
 * Explain that this is a graph traversal problem where each '1' is a node, and edges connect adjacent '1's.
 *
 * Mention that DFS or BFS can be used to explore and mark all connected '1's as part of the same island.
 *
 * 3. Propose a Solution
 * Explain the DFS approach:
 *
 * Iterate through each cell in the grid.
 *
 * When a '1' is found, start DFS to mark all connected '1's as visited (by setting them to '0').
 *
 * Increment the island count for each new island found.
 *
 * 4. Discuss Edge Cases
 * Empty grid.
 *
 * Grid with no islands.
 *
 * Grid with a single island covering the entire grid.
 *
 * Grid with multiple small islands.
 *
 * 5. Write the Code
 * Write clean, modular code with comments explaining key steps.
 *
 * Use meaningful variable names (e.g., rows, cols, numIslands).
 *
 * 6. Test the Code
 * Walk through a small example to verify correctness.
 *
 * Mention the time and space complexity.
 */