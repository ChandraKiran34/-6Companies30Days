import java.util.Arrays;

public class MovesArray2 {

    public int minMoves2(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);

        // Find the median of the array which will be our target number
        // Using bitwise right shift for finding the mid element (equivalent to dividing
        // by 2)
        int median = nums[nums.length >> 1];

        // Initialize the number of moves required to bring all elements to the median
        int moves = 0;

        // Calculate the total number of moves required
        // by summing up the distance of each element from the median
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        // Return the total number of moves
        return moves;
    }
}
