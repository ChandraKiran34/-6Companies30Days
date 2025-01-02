import java.util.*;
public class RandomPointOverlapping {
        private final int[] prefixSums;
        private final int[][] rectangles;
        private final Random random = new Random();
    
        public RandomPointOverlapping(int[][] rects) {
            int n = rects.length;
            this.rectangles = rects;
            prefixSums = new int[n + 1]; 
            for (int i = 0; i < n; ++i) {
                // Calculate the area of the current rectangle using (width * height)
                // and add it to the prefix sum.
                prefixSums[i + 1] = prefixSums[i] +
                    (rectangles[i][2] - rectangles[i][0] + 1) *
                    (rectangles[i][3] - rectangles[i][1] + 1);
            }
        }
    
        public int[] pick() {
            int n = rectangles.length;
            // Pick a random value that falls within the range of total number of points.
            int randomValue = 1 + random.nextInt(prefixSums[n]);
          
            // Binary search to find the rectangle that the point falls into based
            // on the randomValue.
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefixSums[mid] >= randomValue) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
          
            // Get the rectangle where the point falls into.
            int[] selectedRect = rectangles[left - 1];
          
            // Randomly pick a point within the selected rectangle.
            return new int[] {
                // X coordinate
                selectedRect[0] + random.nextInt(selectedRect[2] - selectedRect[0] + 1),
                // Y coordinate
                selectedRect[1] + random.nextInt(selectedRect[3] - selectedRect[1] + 1)
            };
        }
    
}
