package com.yogesh.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfProvincesTest {
    @Test
    void testFullyConnectedGraph() {
        int[][] isConnected = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(1, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(1, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testDisconnectedGraph() {
        int[][] isConnected = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertEquals(3, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(3, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testLargeChainOfCities() {
        int[][] isConnected = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1}
        };
        assertEquals(1, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(1, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testSparseConnectivity() {
        int[][] isConnected = {
                {1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        assertEquals(3, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(3, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testSingleNode() {
        int[][] isConnected = {
                {1}
        };
        assertEquals(1, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(1, new NumberOfProvinces().noOfProvinces(isConnected));

    }

    @Test
    void testLargerGraphWithMixedConnectivity() {
        int[][] isConnected = {
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1}
        };
        assertEquals(4, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(4, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testGraphWithOneLargeAndSeveralSmallProvinces() {
        int[][] isConnected = {
                {1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1}
        };
        assertEquals(4, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(4, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testCircularConnectivity() {
        int[][] isConnected = {
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        assertEquals(1, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(1, new NumberOfProvinces().noOfProvinces(isConnected));
    }

    @Test
    void testRandomSparseConnectivity() {
        int[][] isConnected = {
                {1, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1}
        };
        assertEquals(3, new NumberOfProvinces().findCircleNum(isConnected));
        assertEquals(3, new NumberOfProvinces().noOfProvinces(isConnected));
    }
}
