// leetcode 27. Remove Element
// TC: O(n) SC: O(1)
package arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        RemoveElement obj = new RemoveElement();
        int k = obj.removeElement(nums, val);
        System.out.println("New length: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
