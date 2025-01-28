package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RottenOrangesTest {
    @Test
    void testSimpleGridWithImmediateRot() {
        int[][] grid = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        assertEquals(4, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {
                {2, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(0, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testNoRottenOranges() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(-1, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testSingleRottenOrangeSurroundedByFresh() {
        int[][] grid = {
                {1, 1, 1},
                {1, 2, 1},
                {1, 1, 1}
        };
        assertEquals(2, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testMultipleRottenOranges() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 2}
        };
        assertEquals(2, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testAllFreshOrangesInIsolatedClusters() {
        int[][] grid = {
                {1, 1, 0, 2},
                {0, 0, 1, 0},
                {2, 0, 0, 1},
                {0, 1, 1, 1}
        };
        assertEquals(-1, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testLargeGridNoObstacles() {
        int[][] grid = {
                {2, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 2}
        };
        assertEquals(4, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testSingleRowWithObstacles() {
        int[][] grid = {
                {2, 1, 0, 1, 2}
        };
        assertEquals(1, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testSingleCellRottenOrange() {
        int[][] grid = {
                {2}
        };
        assertEquals(0, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testSingleCellFreshOrange() {
        int[][] grid = {
                {1}
        };
        assertEquals(-1, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testSingleCellEmptyCell() {
        int[][] grid = {
                {0}
        };
        assertEquals(0, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testRottenOrangeIsolatedByObstacles() {
        int[][] grid = {
                {2, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };
        assertEquals(-1, new RottenOranges().orangesRotting(grid));
    }

    @Test
    void testFreshOrangesSurroundedByEmptyCells() {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        assertEquals(-1, new RottenOranges().orangesRotting(grid));
    }
}
