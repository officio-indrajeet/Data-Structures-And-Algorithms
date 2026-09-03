// Leetcode 42. Trapping Rain Water
// Time Complexity: O(n)
// Space Complexity: O(1)

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Compare the heights at the left and right pointers
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update leftMax if current height is greater
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // right side is lower or equal, process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update rightMax if current height is greater
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int trappedWater = solution.trap(height);
        System.out.println("Total trapped rain water: " + trappedWater); // Output: 6
    }
}
