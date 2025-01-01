class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        // Get the dimensions of the image
        int rows = img.length;
        int cols = img[0].length;
      
        // Initialize the smoothed image array
        int[][] smoothedImg = new int[rows][cols];

        // Iterate through each pixel in the image
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int sum = 0; // Sum of pixel values in the smoothing window
                int count = 0; // Number of pixels in the smoothing window
              
                // Iterate through the neighboring pixels including the current pixel
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        // Check if the neighbor is within the image boundaries
                        if (x >= 0 && x < rows && y >= 0 && y < cols) {
                            count++; // Increment the pixel count
                            sum += img[x][y]; // Add the pixel value to the sum
                        }
                    }
                }

                // Compute the average pixel value and assign it to the smoothed image
                smoothedImg[i][j] = sum / count;
            }
        }

        // Return the smoothed image
        return smoothedImg;
    }
}
