package com.yogesh.graphs.unionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfIslands2 {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count; // Number of islands

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = 0;
            Arrays.fill(parent, -1); // -1 means water (not initialized)
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--; // Merging two islands, so decrement count
            }
        }

        public void addLand(int x) {
            if (parent[x] == -1) { // Only process new land
                parent[x] = x;
                count++; // Increase island count
            }
        }

        public int getCount() {
            return count;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0) {
            return result;
        }
        UnionFind uf = new UnionFind(m * n);
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int index = row * n + col;
            uf.addLand(index);

            for (int[] dir : directions) {
                int i = row + dir[0];
                int j = col + dir[1];
                int newIndex = i * n + j;

                if (i >= 0 && i < m && j >= 0 && j < n && uf.parent[newIndex] != -1) {
                    uf.union(index, newIndex);
                }
            }
            result.add(uf.getCount());
        }
        return result;
    }
}
