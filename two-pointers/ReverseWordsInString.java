// Leetcode 151: Reverse Words in a String
// Time Complexity: O(n)
// Space Complexity: O(n)

public class ReverseWordsInString {

    public String reverseWords(String s) {

        char[] arr = s.toCharArray();
        int n = arr.length;

        // Reverse the entire string
        reverse(arr, 0, n - 1);

        int i = 0;
        int l = 0;
        int r = 0;

        while (i < n) {

            // Skip the spaces
            while (i < n && arr[i] == ' ') {
                i++;
            }

            // found the characters of the word, copy them to the result
            while (i < n && arr[i] != ' ') {
                arr[r] = arr[i];
                r++;
                i++;
            }

            if (l < r) {
                // Reverse the word in place
                reverse(arr, l, r - 1);

                // Add a space after the word if there is still space in the array
                if (r < n) {
                    arr[r++] = ' ';
                }

                l = r;

            }

        }

        // Remove the trailing space if there is one
        if (r > 0 && arr[r - 1] == ' ') {
            r--;
        }

        return new String(arr).substring(0, r);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}