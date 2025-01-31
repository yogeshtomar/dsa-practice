package com.yogesh.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortedSquaresTest {
    @Test
    public void testExample1() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100};
        assertArrayEquals(expected, new SortedSquares().sortedSquares(nums));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] nums = {-5, -3, -2, -1};
        int[] expected = {1, 4, 9, 25};
        assertArrayEquals(expected, new SortedSquares().sortedSquares(nums));
    }

    @Test
    public void testAllPositiveNumbers() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {1, 4, 9, 16};
        assertArrayEquals(expected, new SortedSquares().sortedSquares(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {-2};
        int[] expected = {4};
        assertArrayEquals(expected, new SortedSquares().sortedSquares(nums));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int[] expected = {};
        assertArrayEquals(expected, new SortedSquares().sortedSquares(nums));
    }

    @Test
    public void testMixedNumbers() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] expected = {4, 9, 9, 49, 121};
        assertArrayEquals(expected, new SortedSquares().sortedSquares(nums));
    }
}
