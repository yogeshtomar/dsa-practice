package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FloodFillTest {
    @Test
    void testSimpleFloodFill() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 1, 1, 2));
    }

    @Test
    void testNoChangeIfNewColorSameAsOldColor() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 1, 1, 1));
    }

    @Test
    void testSinglePixelChange() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {0}
        };
        int[][] expected = {
                {2}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 0, 0, 2));
    }

    @Test
    void testDisconnectedRegion() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = {
                {1, 0, 1},
                {0, 2, 0},
                {1, 0, 1}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 1, 1, 2));
    }

    @Test
    void testLargeGridWithIsolatedPixel() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        int[][] expected = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 2, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 2, 2, 2));
    }

    @Test
    void testLargeGrid() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        int[][] expected = {
                {1, 1, 1, 1, 1},
                {1, 2, 2, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 2, 2, 1},
                {1, 1, 1, 1, 1}
        };

        int[][] result = floodFill.floodFill(image, 1, 1, 2);

        // Validate using assertArrayEquals
        assertArrayEquals(expected, result);
    }

    @Test
    void testEdgeFloodFill() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[][] expected = {
                {2, 2, 2, 2},
                {2, 0, 0, 2},
                {2, 0, 0, 2},
                {2, 2, 2, 2}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 0, 0, 2));
    }

    @Test
    void testFloodFillWithIrregularShapes() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        int[][] expected = {
                {2, 2, 0, 0},
                {2, 2, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 0, 0, 2));
    }

    @Test
    void testNonSquareGrid() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 0, 0}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 0, 0}
        };
        assertArrayEquals(expected, floodFill.floodFill(image, 0, 0, 2));
    }
}
