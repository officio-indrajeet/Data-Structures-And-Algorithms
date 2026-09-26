// leetcode 414. Third Maximum Number
// TC: O(n) SC: O(1)
package arrays;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == max1 || num == max2 || num == max3) {
                continue;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber solution = new ThirdMaximumNumber();
        int[] nums = { 3, 2, 1 };
        System.out.println(solution.thirdMax(nums)); // Output: 1
    }
}
