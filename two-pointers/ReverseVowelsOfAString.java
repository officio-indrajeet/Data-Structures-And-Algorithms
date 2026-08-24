// Leetcode Problem 345: Reverse Vowels of a String
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
            } else if (!isVowel(chars[right])) {
                right--;
            } else { // Both chars[left] and chars[right] are vowels, swap them
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        String input = "IceCreAm";
        String output = solution.reverseVowels(input);
        System.out.println(output); // Output: "AceCreIm"
    }
}
