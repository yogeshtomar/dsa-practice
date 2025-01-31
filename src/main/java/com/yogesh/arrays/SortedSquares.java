package com.yogesh.arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n-1;
        int index = n-1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }
}

/**
 * Explanation
 * Two-Pointer Approach:
 *
 * Use two pointers, left and right, to traverse the array from both ends.
 *
 * Compare the squares of the numbers at left and right.
 *
 * Place the larger square at the end of the result array and move the corresponding pointer.
 *
 * Efficiency:
 *
 * The algorithm runs in a single pass through the array, making it efficient.
 *
 * Time and Space Complexity
 * Time Complexity: O(N), where N is the length of the input array. We process each element once.
 *
 * Space Complexity: O(N) for the output array. If we ignore the output array, the space complexity is O(1).
 */
