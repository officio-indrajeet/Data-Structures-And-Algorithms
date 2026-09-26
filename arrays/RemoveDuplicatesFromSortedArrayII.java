// leetcode 80. Remove Duplicates from Sorted Array II
// TC: O(n) SC: O(1)
package arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int left = 0;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[left]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
        int k = obj.removeDuplicates(nums);
        System.out.println("New length: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
