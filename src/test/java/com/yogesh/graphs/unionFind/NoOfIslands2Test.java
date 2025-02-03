package com.yogesh.graphs.unionFind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoOfIslands2Test {
    @Test
    public void testExample1() {
        int m = 3, n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        List<Integer> expected = Arrays.asList(1, 1, 2, 3);
        assertEquals(expected, new NoOfIslands2().numIslands2(m, n, positions));
    }

    @Test
    public void testNoPositions() {
        int m = 3, n = 3;
        int[][] positions = {};
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, new NoOfIslands2().numIslands2(m, n, positions));
    }

    @Test
    public void testSingleIsland() {
        int m = 2, n = 2;
        int[][] positions = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        List<Integer> expected = Arrays.asList(1, 1, 1, 1);
        assertEquals(expected, new NoOfIslands2().numIslands2(m, n, positions));
    }

    @Test
    public void testMultipleIslands() {
        int m = 3, n = 3;
        int[][] positions = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, new NoOfIslands2().numIslands2(m, n, positions));
    }
}
