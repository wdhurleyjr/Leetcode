/*
Notes:

Time Complexity: O(M × N)
Space Complexity: O(1)

This solution flips and inverts a binary image (2D matrix) in place.

Algorithm:
1. Iterate over each row of the matrix (`image`) using an outer loop.
   - For each row, use a two-pointer approach (`i` and `j`) to process the row.
2. While `i` is less than or equal to `j`:
   - Swap the elements at positions `i` and `j`.
   - Invert the values at these positions:
     - If the value is `1`, invert it to `0`.
     - If the value is `0`, invert it to `1`.
   - Increment `i` and decrement `j` to move the pointers inward.
3. Repeat the above steps for all rows in the matrix.
4. Return the modified matrix after all rows have been processed.

Key Insight:
This solution combines flipping (reversing the row) and inverting (flipping binary values) in a single pass using a two-pointer technique. It performs all operations in place, reducing the space complexity to O(1). The time complexity is O(M × N), as each element in the matrix is processed exactly once.
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int m = 0; m < image.length; m++) {
            int[] arr = image[m];
            int i = 0;
            int j = arr.length - 1;
            while(i <= j) {
                int temp = arr[i];
                arr[i] = invert(arr[j]);
                arr[j] = invert(temp);
                i++;
                j--;
            }
        }
        return image;
    }
    private int invert(int i) {
        return i ^ 1;
    }
}