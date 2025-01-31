package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DistanceOfNearestOnesInBinaryMatrixTest {
    private final DistanceOfNearestOnesInBinaryMatrix matrix01 = new DistanceOfNearestOnesInBinaryMatrix();

    @Test
    void testSingleElementMatrix() {
        int[][] mat1 = {{0}};
        int[][] expected1 = {{Integer.MAX_VALUE}};
        assertArrayEquals(expected1, matrix01.nearestOnes(mat1));

        int[][] mat2 = {{1}};
        int[][] expected2 = {{0}};
        assertArrayEquals(expected2, matrix01.nearestOnes(mat2));
    }

    @Test
    void testSmallMatrixWithOnlyZeros() {
        int[][] mat = {
                {0, 0},
                {0, 0}
        };
        int[][] expected = {
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testSmallMatrixWithOnlyOnes() {
        int[][] mat = {
                {1, 1},
                {1, 1}
        };
        int[][] expected = {
                {0, 0},
                {0, 0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testSmallMixedMatrix() {
        int[][] mat = {
                {0, 1},
                {1, 1}
        };
        int[][] expected = {
                {1, 0},
                {0, 0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testLargeMixedMatrix() {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] expected = {
                {2, 1, 2},
                {1, 0, 1},
                {0, 0, 0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testLargeSparseMatrix() {
        int[][] mat = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        int[][] expected = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testSingleRowMatrix() {
        int[][] mat = {{0, 1, 1, 0, 1}};
        int[][] expected = {{1, 0, 0, 1, 0}};
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testSingleColumnMatrix() {
        int[][] mat = {
                {0},
                {1},
                {1},
                {0},
                {1}
        };
        int[][] expected = {
                {1},
                {0},
                {0},
                {1},
                {0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testDisconnectedRegions() {
        int[][] mat = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 0, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }

    @Test
    void testAllOnesFarFromZeros() {
        int[][] mat = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        assertArrayEquals(expected, matrix01.nearestOnes(mat));
    }
}
