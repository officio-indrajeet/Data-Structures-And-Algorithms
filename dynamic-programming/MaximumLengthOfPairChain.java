// 646. Maximum Length of Pair Chain (Medium)
// https://leetcode.com/problems/maximum-length-of-pair-chain/

class Solution {
    /* memoization - Top down DP
    ** Time complexity - O(n^2)
    */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1])); // You can select pairs in any order.
        int[][] dp = new int[1001][1001];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return solve(pairs, 0, -1, dp);
    }

    private int solve(int[][] pairs, int curr_idx, int prev_idx, int[][] dp) {
        if(curr_idx >= pairs.length) return 0;

        if(prev_idx != -1 && dp[curr_idx][prev_idx] != -1) {
            return dp[curr_idx][prev_idx];
        }

        // take
        int take = 0;
        if(prev_idx == -1 || pairs[prev_idx][1] < pairs[curr_idx][0]) {
            take = 1 + solve(pairs, curr_idx+1, curr_idx, dp);
        }

        int skip = solve(pairs, curr_idx + 1, prev_idx, dp);

         if(prev_idx != -1) {
            dp[curr_idx][prev_idx] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }
}
    
/* Recursion - O(2^n)
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1])); // You can select pairs in any order.
        return solve(pairs, 0, -1);
    }

    private int solve(int[][] pairs, int curr_idx, int prev_idx) {
        if(curr_idx >= pairs.length) return 0;

        // take
        int take = 0;
        if(prev_idx == -1 || pairs[prev_idx][1] < pairs[curr_idx][0]) {
            take = 1 + solve(pairs, curr_idx+1, curr_idx);
        }

        int skip = solve(pairs, curr_idx + 1, prev_idx);
        return Math.max(take, skip);
    }
}
*/
