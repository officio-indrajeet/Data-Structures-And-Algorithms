// 300. Longest Increasing Subsequence (Medium)
// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    /** Memoization - Top Down DP */
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, -1, dp);
    }
    private int solve(int[] nums, int idx, int prev, int[][] dp) {
        if(idx >= nums.length) return 0;

        if(prev != -1 && dp[idx][prev] != -1) {
            return dp[idx][prev];
        }

        // take
        int take = 0;
        if(prev == -1 || nums[prev] < nums[idx]) {
            take = 1 + solve(nums, idx+1, idx, dp);
        }

        // skip
        int skip = solve(nums, idx+1, prev, dp);
        if(prev != -1) {
            dp[idx][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
}

/* 
    Recursion - Time complexity: O(2^n)
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        return solve(nums, 0, -1);
    }

    private int solve(int[] nums, int idx, int prev) {
        if(idx >= nums.length) return 0;

        // take
        int take = 0;
        if(prev == -1 || nums[prev] < nums[idx]) {
            take = 1 + solve(nums, idx+1, idx);
        }

        // skip
        int skip = solve(nums, idx+1, prev);

        return Math.max(take, skip);
    }
*/
