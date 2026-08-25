// Leetcode Problem: 15. 3Sum
// Time Complexity: O(n^2)
// Space Complexity: O(n) for the result list

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break; // Since the array is sorted, no need to continue if the current number is
                       // greater than 0
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates for the first number

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println("Unique triplets that sum to zero: " + result);
    }

}
