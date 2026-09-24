// leetcode 283. Move Zeroes
// TC: O(n) SC: O(1)
package arrays;

public class moveZeroes {
    public void moveZeros(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeroes obj = new moveZeroes();
        obj.moveZeros(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
