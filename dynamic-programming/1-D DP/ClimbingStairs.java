// leetcode 70. Climbing Stairs
// TC: O(n)
// SC: O(1) for optimized space complexity, O(n) for memoization and

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        /*
         * memoization approach : Top down dynamic programming
         * int[] dp = new int[n + 1];
         * Arrays.fill(dp, -1);
         * return climbStairsHelper(n, dp);
         * TC: O(n) SC: O(n) for recursion stack + O(n) for dp array = O(n)
         */

        /*
         * Bottom up dynamic programming approach
         * int[] dp = new int[n + 1];
         * dp[0] = 1;
         * dp[1] = 1;
         * for (int i = 2; i <= n; i++) {
         * dp[i] = dp[i - 1] + dp[i - 2];
         * }
         * return dp[n];
         * TC: O(n) SC: O(n) for dp array
         */

        // Optimized space complexity to O(1)
        int prev = 1, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    private int climbStairsHelper(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 5;
        System.out.println(solution.climbStairs(n)); // Output: 8
    }
}
