// Leetcode Problem: 26. Remove Duplicates from Sorted Array
// Time Complexity: O(n)
// Space Complexity: O(1)

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int i = 0;
        int j = 1;

        while (j < n) {
            if (nums[i] != nums[j]) { // Found a new unique element
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1; // Return the count of unique elements
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int uniqueCount = solution.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + uniqueCount);
        System.out.print("Modified array: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
