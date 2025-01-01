import java.util.Arrays;

class EnvolopesDolls {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width in ascending order; if widths are equal, sort by height in descending order.
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
      
        int numEnvelopes = envelopes.length;
        // 'heights' array stores the heights at which envelopes will end at each position in the subsequence.
        int[] heights = new int[numEnvelopes + 1];
        // Initialize the first height in the 'heights' array
        heights[1] = envelopes[0][1];
        // 'maxSize' represents the length of the longest increasing subsequence so far.
        int maxSize = 1;
      
        for (int i = 1; i < numEnvelopes; ++i) {
            int currentHeight = envelopes[i][1];
            // If the current envelope's height is greater than the last envelope's height in the 'heights' array,
            // it can be appended to the subsequence.
            if (currentHeight > heights[maxSize]) {
                heights[++maxSize] = currentHeight;
            } else {
                // Perform binary search to find the correct position to place current envelope's height.
                int left = 1, right = maxSize;
                while (left < right) {
                    int mid = (left + right) >> 1; // Equivalent to (left + right) / 2
                    if (heights[mid] >= currentHeight) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                // Update the 'heights' array with the current envelope's height at the correct position.
                int pos = (heights[left] >= currentHeight) ? left : 1;
                heights[pos] = currentHeight;
            }
        }
        // Return the length of the longest increasing subsequence which corresponds to the maximum number of envelopes.
        return maxSize;
    }
}
