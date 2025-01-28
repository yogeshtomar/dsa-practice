package com.yogesh.graphs.traversal;

import java.util.List;

public class DetectCycleDFS {
    public boolean detectCycleOnALlVertex(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(adjList, i, visited, -1)) {
                return true;
            }
        }
         return false;
    }

    private boolean dfs(List<List<Integer>> adjList, int source, boolean[] visited, int parent) {
        visited[source] = true;
        for (int neighbor : adjList.get(source)) {
            if (!visited[neighbor]) {
                if (dfs(adjList, neighbor, visited, source)) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
