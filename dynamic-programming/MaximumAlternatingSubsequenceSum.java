// 2022. Maximum Alternating Subsequence Sum (Medium)
// https://leetcode.com/problems/maximum-alternating-subsequence-sum/

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];

        for(int i=1;i<n+1;i++) {
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1], dp[i-1][1]);
        }

        return Math.max(dp[n][0], dp[n][1]);
    }

    /* Memoization (Top-down DP)
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for(long[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, dp, 0); // 0 -> + (true) 1 -> - (false)
    }

     private long solve(int[] nums, int idx, long[][] dp, int isEven) {

        if(idx >= nums.length) return 0;

         if(dp[idx][isEven] != -1) {
            return dp[idx][isEven];
        }

        long skip = solve(nums, idx+1 , dp, isEven);

        long val = (isEven == 0) ? nums[idx] : -nums[idx];

        long take = solve(nums, idx+1 , dp, 1 - isEven) + val;

        return dp[idx][isEven] = Math.max(skip, take);
    }

    */




    /* Recursion solution
    public long maxAlternatingSum(int[] nums) {
        return solve(nums, 0, true);
    }

    private long solve(int[] nums, int idx, boolean isEven) {

        if(idx >= nums.length) return 0;

        long skip = solve(nums, idx+1 , isEven);

        int val = nums[idx];
        if(isEven == false) {
            val = -val;
        }

        long take = solve(nums, idx+1 , !isEven) + val;

        return Math.max(skip, take);
    }
    */
}
