// leetcode 169. Majority Element
// TC: O(n) SC: O(1)
package arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = { 3, 2, 3 };
        System.out.println(solution.majorityElement(nums)); // Output: 3
    }
}
