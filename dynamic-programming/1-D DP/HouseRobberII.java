// leetcode 213. House Robber II
// TC: O(n)
// SC: O(n) for memoization and bottom-up DP

public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses from index 0 to n-2
        int maxRob1 = robHelper(nums, 0, n - 2);

        // Case 2: Rob houses from index 1 to n-1
        int maxRob2 = robHelper(nums, 1, n - 1);

        return Math.max(maxRob1, maxRob2);
    }

    private int robHelper(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[start];
        if (n == 2)
            return Math.max(nums[start], nums[start + 1]);

        // Bottom-up dynamic programming approach
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();
        int[] nums = { 2, 3, 2 };
        System.out.println(solution.rob(nums)); // Output: 3
    }

}
