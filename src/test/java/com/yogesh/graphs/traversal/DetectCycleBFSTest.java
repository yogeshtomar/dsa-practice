package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetectCycleBFSTest {
    @Test
    void testDirectedGraphWithCycle() {
        int V = 3;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Graph:
        // 0 -> 1 -> 2 -> 0 (Cycle)
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(0);

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertTrue(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }

    @Test
    void testDirectedGraphWithoutCycle() {
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Graph:
        // 0 -> 1 -> 2 -> 3 (No Cycle)
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertFalse(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }

    @Test
    void testUndirectedGraphWithCycle() {
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Graph:
        // 0 -- 1
        // |    |
        // 3 -- 2 (Cycle)
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(0);
        adjList.get(0).add(3);

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertTrue(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }

    @Test
    void testUndirectedGraphWithoutCycle() {
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Graph:
        // 0 -- 1    2 -- 3 (No Cycle)
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertFalse(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }

    @Test
    void testSingleNodeNoCycle() {
        int V = 1;
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>()); // Single node, no edges

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertFalse(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }

    @Test
    void testDisconnectedGraphWithCycle() {
        int V = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Graph:
        // Component 1: 0 -> 1 -> 2 -> 0 (Cycle)
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(0);

        // Component 2: 3 -> 4 -> 5 (No Cycle)
        adjList.get(3).add(4);
        adjList.get(4).add(5);

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertTrue(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }

    @Test
    void testDisconnectedGraphWithoutCycle() {
        int V = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Graph:
        // Component 1: 0 -> 1 -> 2 (No Cycle)
        adjList.get(0).add(1);
        adjList.get(1).add(2);

        // Component 2: 3 -> 4 -> 5 (No Cycle)
        adjList.get(3).add(4);
        adjList.get(4).add(5);

        DetectCycleBFS detectCycleBFS = new DetectCycleBFS();
        assertFalse(detectCycleBFS.detectCycleAllVertex(V, adjList));
    }
}
