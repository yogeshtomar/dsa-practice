package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusRotesTest {
    private BusRoutes busRoutes = new BusRoutes();
    @Test
    public void testExample1() {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int S = 1;
        int T = 6;
        int expected = 2;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testExample() {
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int S = 15;
        int T = 12;
        int expected = -1;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testSameSourceAndTarget() {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int S = 1;
        int T = 1;
        int expected = 0;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testNoPossibleRoute() {
        int[][] routes = {{1, 2, 3}, {4, 5, 6}};
        int S = 1;
        int T = 6;
        int expected = -1;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testSingleRoute() {
        int[][] routes = {{1, 2, 3, 4, 5}};
        int S = 1;
        int T = 5;
        int expected = 1;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testMultipleRoutesWithSameStop() {
        int[][] routes = {{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
        int S = 1;
        int T = 7;
        int expected = 3;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testLargeInput() {
        int[][] routes = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {10, 11, 12, 13, 14, 15}, {15, 16, 17, 18, 19, 20}};
        int S = 1;
        int T = 20;
        int expected = 3;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testDisconnectedRoutes() {
        int[][] routes = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int S = 1;
        int T = 9;
        int expected = -1;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testComplexRoutes() {
        int[][] routes = {{1, 2, 3}, {3, 4, 5}, {5, 6, 7}, {7, 8, 9}, {9, 10, 11}};
        int S = 1;
        int T = 11;
        int expected = 5;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testEmptyRoutes() {
        int[][] routes = {};
        int S = 1;
        int T = 2;
        int expected = -1;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testSingleStopRoutes() {
        int[][] routes = {{1}, {2}, {3}, {4}, {5}};
        int S = 1;
        int T = 5;
        int expected = -1;
        assertEquals(expected, busRoutes.numBusesToDestination(routes, S, T));
    }
}
