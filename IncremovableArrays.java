
// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/

public class IncremovableArrays {
    public int incremovableSubarrayCount(int[] nums) {
        int leftIndex = 0, n = nums.length;

        // Increment leftIndex until the current element is no longer smaller than the
        // next
        while (leftIndex + 1 < n && nums[leftIndex] < nums[leftIndex + 1]) {
            ++leftIndex;
        }

        // If the entire array is already increasing, return the sum
        // of all subarrays possible
        if (leftIndex == n - 1) {
            return n * (n + 1) / 2;
        }

        // Otherwise, start the answer by counting subarrays including
        // nums[0] to nums[leftIndex] and one element after that
        int result = leftIndex + 2;

        // Iterate from the end of the array towards the start
        for (int rightIndex = n - 1; rightIndex > 0; --rightIndex) {
            // Find the first number from the left that is smaller than
            // nums[rightIndex] to extend the subarray
            while (leftIndex >= 0 && nums[leftIndex] >= nums[rightIndex]) {
                --leftIndex;
            }

            // Count the subarrays which include nums[rightIndex] and all possible starts to
            // its left
            result += leftIndex + 2;

            // If the array is not increasing from nums[rightIndex - 1] to nums[rightIndex],
            // break the loop as we cannot make further incremovable subarrays to the right
            if (nums[rightIndex - 1] >= nums[rightIndex]) {
                break;
            }
        }
        return result;
    }
}