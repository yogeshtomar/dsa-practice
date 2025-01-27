package com.yogesh.graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;

        List<List<Integer>> adjList = getAdjList(isConnected, m, n);

        int[] visited = new int[m];
        int count = 0;

        for (int i = 0; i < m; i++) {
            if (visited[i] != 1) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }

    public int noOfProvinces(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

    private void dfs(int index, List<List<Integer>> adj, int[] visited) {
        visited[index] = 1;
        for (int i : adj.get(index)) {
            if (visited[i] != 1) {
                dfs(i, adj, visited);
            }
        }
    }

    private List<List<Integer>> getAdjList(int[][] isConnected, int m, int n) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        return adjList;
    }
}
