// leetcode 442. Find All Duplicates in an Array
// TC: O(n) SC: O(1), ignoring the output list
package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray solution = new FindAllDuplicatesInAnArray();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(solution.findDuplicates(nums)); // Output: [2, 3]
    }
}
