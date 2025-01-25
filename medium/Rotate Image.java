/*
Notes:

Time Complexity: O(n^2)
Space Complexity: O(1)

This solution rotates a given n x n 2D matrix clockwise by 90 degrees in place, meaning no additional memory is used beyond the matrix itself.

Approach:
1. **Reverse the Rows**:
   - First, the matrix is reversed top-to-bottom by swapping rows symmetrically. This operation reflects the matrix vertically.
   - Example: Before reversing:
       1 2 3       After reversing:
       4 5 6       7 8 9
       7 8 9       4 5 6
                   1 2 3

2. **Transpose the Matrix**:
   - After reversing, the matrix is transposed by swapping `matrix[i][j]` with `matrix[j][i]` for all `i < j`.
   - Transposition ensures the columns are converted into rows, completing the 90-degree clockwise rotation.
   - Example: After transposition:
       7 4 1
       8 5 2
       9 6 3

Steps:
1. The `rotate` function calls a helper method `reverse` to vertically flip the matrix.
2. Transpose the matrix by iterating through the upper triangle of the matrix and swapping elements.

Key Observations:
- Reversing rows converts the rotation problem into a simpler transposition problem.
- The `reverse` function swaps entire rows to achieve the vertical reflection.
- Transposing works on the upper triangle (i.e., `j >= i`) to avoid redundant swaps and ensures efficiency.

Overall:
- The algorithm performs in-place with O(1) space complexity and processes all `n^2` elements, resulting in O(n^2) time complexity.
*/

class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        reverse(matrix);
        for(int i = 0; i < l; i++) {
            for(int j = i; j < l; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void reverse(int[][] matrix) {
        int l = matrix.length;
        for(int i = 0; i < l / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[l - 1 - i];
            matrix[l - 1 - i] = temp;
        }
    }
}
