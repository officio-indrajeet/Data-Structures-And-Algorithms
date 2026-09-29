// leetcode 509. Fibonacci Number
// TC: O(n)
// SC: O(1) for optimized space complexity, O(n) for memoization and bottom-up DP

public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        /*
         * memoization approach : Top down dynamic programming
         * int[] dp = new int[n + 1];
         * Arrays.fill(dp, -1);
         * return fibHelper(n, dp);
         * TC: O(n) SC: O(n) for recursion stack + O(n) for dp array = O(n)
         */

        /*
         * Bottom up dynamic programming approach
         * int[] dp = new int[n + 1];
         * dp[0] = 0;
         * dp[1] = 1;
         * for (int i = 2; i <= n; i++) {
         * dp[i] = dp[i - 1] + dp[i - 2];
         * }
         * return dp[n];
         * TC: O(n) SC: O(n) for dp array
         */

        // Optimized space complexity to O(1)
        int prev = 0, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev + prev2;
            prev = prev2;
            prev2 = current;
        }
        return prev2;
    }

    private int fibHelper(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibHelper(n - 1, dp) + fibHelper(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumber solution = new FibonacciNumber();
        int n = 5;
        System.out.println(solution.fib(n)); // Output: 5
    }

}
