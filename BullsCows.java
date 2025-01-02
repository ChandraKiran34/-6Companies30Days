public class BullsCows {
    public String getHint(String secret, String guess) {
        // Initial count of bulls ("A") and cows ("B")
        int bulls = 0, cows = 0;
        // Arrays to keep count of numbers not matched (bulls) in secret and guess
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
      
        // Iterate through each character in secret and guess strings
        for (int i = 0; i < secret.length(); ++i) {
            int secretDigit = secret.charAt(i) - '0'; // Convert char to int
            int guessDigit = guess.charAt(i) - '0'; // Convert char to int
          
            // If digits match at the same index, it's a bull ("A")
            if (secretDigit == guessDigit) {
                ++bulls;
            } else {
                // If not a bull, tally in corresponding count arrays
                ++secretCount[secretDigit];
                ++guessCount[guessDigit];
            }
        }
      
        // Calculate cows ("B") by finding the minimum count of each digit in both secret and guess that were not bulls
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }
      
        // Return the formatted string with bulls ("A") and cows ("B")
        return String.format("%dA%dB", bulls, cows);
    }
}
