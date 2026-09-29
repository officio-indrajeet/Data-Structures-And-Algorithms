// leetcode 746. Min Cost Climbing Stairs
// TC: O(n)
// SC: O(1) for optimized space complexity, O(n) for memoization and bottom-up DP

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return cost[0];
        if (n == 2)
            return Math.min(cost[0], cost[1]);

        /*
         * memoization approach : Top down dynamic programming
         * int[] dp = new int[n];
         * Arrays.fill(dp, -1);
         * return Math.min(minCostHelper(n - 1, cost, dp), minCostHelper(n - 2, cost,
         * dp));
         * TC: O(n) SC: O(n) for recursion stack + O(n) for dp array = O(n)
         */

        // bottom up dynamic programming approach
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);

        /*
         * Optimized space complexity to O(1)
         * int prev = cost[0], prev2 = cost[1];
         * for (int i = 2; i < n; i++) {
         * int current = cost[i] + Math.min(prev, prev2);
         * prev = prev2;
         * prev2 = current;
         * }
         * return Math.min(prev, prev2);
         */

    }

    private int minCostHelper(int idx, int[] cost, int[] dp) {
        if (idx == cost.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int a = cost[idx] + minCostHelper(idx + 1, cost, dp);
        int b = cost[idx] + minCostHelper(idx + 2, cost, dp);
        dp[idx] = Math.min(a, b);
        return dp[idx];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost));
    
}
