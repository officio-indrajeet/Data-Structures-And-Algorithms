// leetcode 163. Missing Ranges
// TC: O(n) 
// SC: O(1): Ignoring the output list, the space complexity is O(1) since 
// we are using a constant amount of extra space for variables.
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }

        // Gap before the first element
        if (lower < nums[0]) {
            result.add(Arrays.asList(lower, nums[0] - 1));
        }

        // Gaps between elements
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                result.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // Gap after the last element
        if (upper > nums[n - 1]) {
            result.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return result;
    }

    public static void main(String[] args) {
        MissingRanges solution = new MissingRanges();
        int[] nums = { 0, 1, 3, 50, 75 };
        int lower = 0;
        int upper = 99;
        List<List<Integer>> missingRanges = solution.findMissingRanges(nums, lower, upper);
        System.out.println(missingRanges); // Output: [[2], [4, 49], [51, 74], [76, 99]]
    }

}
