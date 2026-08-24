// Leetcode Problem: 977. Squares of a Sorted Array
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] result = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
