import java.util.Arrays;
public class DisjointArrays {
    public int maxProduct(String s) {
        // Get the length of the string
        int stringLength = s.length();
        // Initialize a boolean array for palindrome checks with size as all possible subsets
        boolean[] isPalindrome = new boolean[1 << stringLength];
        // Default all entries to true
        Arrays.fill(isPalindrome, true);
      
        // Check each subset to see if it forms a palindrome
        for (int subset = 1; subset < 1 << stringLength; ++subset) {
            for (int left = 0, right = stringLength - 1; left < stringLength; ++left, --right) {
                // Find the next index 'left' where subset has a bit set
                while (left < right && (subset >> left & 1) == 0) {
                    ++left;
                }
                // Find the next index 'right' where subset has a bit set
                while (left < right && (subset >> right & 1) == 0) {
                    --right;
                }
                // If the characters at 'left' and 'right' don't match, it's not a palindrome
                if (left < right && s.charAt(left) != s.charAt(right)) {
                    isPalindrome[subset] = false;
                    break;
                }
            }
        }
      
        int maximumProduct = 0; // Initialize the maximum product of palindrome lengths
      
        // Calculate the product of lengths for all pairs of palindromic subsets
        for (int i = 1; i < 1 << stringLength; ++i) {
            if (isPalindrome[i]) { // If the subset at index i forms a palindrome
                int countA = Integer.bitCount(i); // Count the number of set bits

                // Calculate the complement of subset i
                int complement = ((1 << stringLength) - 1) ^ i;
              
                // Iterate through all subsets of complement
                for (int j = complement; j > 0; j = (j - 1) & complement) {
                    if (isPalindrome[j]) { // If the subset at index j forms a palindrome
                        int countB = Integer.bitCount(j); // Count the number of set bits
                        // Update the maximum product if the current pair product is larger
                        maximumProduct = Math.max(maximumProduct, countA * countB);
                    }
                }
            }
        }
      
        return maximumProduct; // Return the maximum product found
    }
}
