// leetcode 26. Remove Duplicates from Sorted Array
// TC: O(n) SC: O(1)
package arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int k = obj.removeDuplicates(nums);
        System.out.println("New length: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}