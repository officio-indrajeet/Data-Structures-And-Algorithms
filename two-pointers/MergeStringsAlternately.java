// Leetcode Problem 1768: Merge Strings Alternately
// Time Complexity: O(n + m) where n and m are the lengths of word1 and word2
// Space Complexity: O(n + m) for the merged string
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] merged = new char[word1.length() + word2.length()];
        int i = 0, j = 0, k = 0;
        int n1 = word1.length(), n2 = word2.length();

        while (i < n1 && j < n2) {
            merged[k++] = word1.charAt(i++);
            merged[k++] = word2.charAt(j++);
        }

        // Append any remaining characters from either string
        while (i < n1) {
            merged[k++] = word1.charAt(i++);
        }
        while (j < n2) {
            merged[k++] = word2.charAt(j++);
        }

        return new String(merged);
    }

    public static void main(String[] args) {
        MergeStringsAlternately solution = new MergeStringsAlternately();
        String word1 = "abc";
        String word2 = "pqr";
        String result = solution.mergeAlternately(word1, word2);
        System.out.println(result); // Output: "apbqcr"
    }
}