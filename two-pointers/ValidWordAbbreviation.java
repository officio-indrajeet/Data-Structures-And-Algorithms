// Leetcode Problem 408: Valid Word Abbreviation
// Time Complexity: O(n)
// Space Complexity: O(1)
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // Pointer for word
        int j = 0; // Pointer for abbr

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') { // Leading zeros are not allowed
                    return false;
                }
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // Move the pointer in the word by the number found
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false; // Characters do not match
                }
                i++;
                j++;
            }
        }

        return i == word.length() && j == abbr.length(); // Both pointers should reach the end
    }

    public static void main(String[] args) {
        ValidWordAbbreviation solution = new ValidWordAbbreviation();
        String word = "internationalization";
        String abbr = "i12iz4n";
        boolean isValid = solution.validWordAbbreviation(word, abbr);
        System.out.println("Is valid abbreviation: " + isValid); // Output: true
    }
}