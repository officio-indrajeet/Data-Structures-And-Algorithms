// leetcode 198. House Robber
// TC: O(n)
// SC: O(1) for optimized space complexity, O(n) for memoization and bottom-up DP

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        /*
         * memoization approach : Top down dynamic programming
         * int[] dp = new int[n];
         * Arrays.fill(dp, -1);
         * return robHelper(n - 1, nums, dp);
         * TC: O(n) SC: O(n) for recursion stack + O(n) for dp array = O(n)
         */

        // bottom up dynamic programming approach
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];

        /*
         * Optimized space complexity to O(1)
         * int prev = nums[0], prev2 = Math.max(nums[0], nums[1]);
         * for (int i = 2; i < n; i++) {
         * int current = Math.max(prev2, nums[i] + prev);
         * prev = prev2;
         * prev2 = current;
         * }
         * return prev2;
         */
    }

    private int robHelper(int idx, int[] nums, int[] dp) {
        if (idx >= nums.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int choose = nums[idx] + robHelper(idx + 2, nums, dp);
        int notChoose = robHelper(idx + 1, nums, dp);
        dp[idx] = Math.max(choose, notChoose);
        return dp[idx];
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(solution.rob(nums)); // Output: 12
    }
}
