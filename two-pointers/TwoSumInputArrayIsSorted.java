// Leetcode Problem 167: Two Sum II - Input Array Is Sorted
// Time Complexity: O(n)
// Space Complexity: O(1)

public class TwoSumInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // Return 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 }; // Return an invalid pair if no solution is found
    }

    public static void main(String[] args) {
        TwoSumInputArrayIsSorted solution = new TwoSumInputArrayIsSorted();
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
