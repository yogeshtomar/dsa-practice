package com.yogesh.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentElementsTest {
    @Test
    public void testExample1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        assertArrayEquals(expected, new TopKFrequentElements().topKFrequent(nums, k));
    }

    @Test
    public void testExample2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        assertArrayEquals(expected, new TopKFrequentElements().topKFrequent(nums, k));
    }

    @Test
    public void testAllElementsSame() {
        int[] nums = {4, 4, 4, 4};
        int k = 1;
        int[] expected = {4};
        assertArrayEquals(expected, new TopKFrequentElements().topKFrequent(nums, k));
    }

    @Test
    public void testAllElementsUnique() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int[] expected = {3, 2, 5}; // Any 3 elements are valid
        assertArrayEquals(expected, new TopKFrequentElements().topKFrequent(nums, k));
    }

    @Test
    public void testKEqualsNumberOfUniqueElements() {
        int[] nums = {1, 1, 2, 2, 3};
        int k = 3;
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, new TopKFrequentElements().topKFrequent(nums, k));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int k = 0;
        int[] expected = {};
        assertArrayEquals(expected, new TopKFrequentElements().topKFrequent(nums, k));
    }
}
