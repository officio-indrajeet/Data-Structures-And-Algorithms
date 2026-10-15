/**
 * 213. House Robber II (Medium)
 * https://leetcode.com/problems/house-robber-ii/
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(houseRobber1(nums, 0, n-2) , houseRobber1(nums,1, n-1));
    }

    private int houseRobber1(int[] nums, int start, int end) {
        
        int prev2 = 0;
        int prev1 = 0;
        for(int i=start;i<=end;i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
