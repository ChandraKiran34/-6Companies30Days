import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
         int[] sortedArray = nums.clone();
        // Sort the cloned array in non-decreasing order.
        Arrays.sort(sortedArray);
      
        // Get the size of the array.
        int n = nums.length;
        // Find the mid point of the array to split the values.
        int midIndex = (n - 1) >> 1; // Equivalent to (n-1)/2
        // Set the index for the larger half of the values.
        int highIndex = n - 1;
     
        // Iterate over each index of the original 'nums' array.
        for (int k = 0; k < n; ++k) {
            if (k % 2 == 0) {
                // For even index, assign the next smaller value from the first half of 'sortedArray'.
                nums[k] = sortedArray[midIndex--];
            } else {
                // For odd index, assign the next larger value from the second half of 'sortedArray'.
                nums[k] = sortedArray[highIndex--];
            }
        }
    }
}
