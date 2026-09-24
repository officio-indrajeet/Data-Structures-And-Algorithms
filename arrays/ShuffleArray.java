// leetcode 1470. Shuffle the Array
// TC: O(n) SC: O(n)
package arrays;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[2 * n];
        for (int i = 0; i < n; i++) {
            shuffled[2 * i] = nums[i];
            shuffled[2 * i + 1] = nums[i + n];
        }
        return shuffled;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        ShuffleArray obj = new ShuffleArray();
        int[] shuffled = obj.shuffle(nums, n);
        for (int num : shuffled) {
            System.out.print(num + " ");
        }
    }

}
