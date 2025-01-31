package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoOfIslandsTest {
    @Test
    public void testExample1() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }

    @Test
    public void testNoIslands() {
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        int expected = 0;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }

    @Test
    public void testSingleIsland() {
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        int expected = 1;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }

    @Test
    public void testDiagonalIslands() {
        char[][] grid = {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        int expected = 5;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }

    @Test
    public void testEmptyGrid() {
        char[][] grid = {};
        int expected = 0;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }

    @Test
    public void testSingleCellIsland() {
        char[][] grid = {{'1'}};
        int expected = 1;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }

    @Test
    public void testSingleCellWater() {
        char[][] grid = {{'0'}};
        int expected = 0;
        assertEquals(expected, new NoOfIslands().numIslands(grid));
    }
}
