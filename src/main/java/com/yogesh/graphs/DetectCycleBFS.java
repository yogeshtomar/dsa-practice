package com.yogesh.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleBFS {
    public boolean detectCycleAllVertex(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];

        // Traverse all vertices to handle disconnected graphs
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adjList, i, visited)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle foun
    }

    private boolean bfs(List<List<Integer>> adjList, int start, boolean[] visited) {
        // Queue to hold (current node, parent node)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // Start with the source node, no parent (-1)
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            // Traverse neighbors of the current node
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node}); // Add the neighbor with its parent
                } else if (neighbor != parent) {
                    // If the neighbor is visited and not the parent, a cycle is found
                    return true;
                }
            }
        }
        return false;
    }

}
