/*
Time Complexity: O(log(m) + log(n)) -> O(log(m * n))
Space Complexity: O(1)

This solution searches for a target in a row-wise and column-wise sorted 2D matrix using a two-step binary search approach.

Algorithm:
1. Use binary search to locate the potential row:
   - `top` starts at the first row, and `bottom` starts at the last row.
   - Calculate the middle row index (`mid`).
   - Check if the target could exist in the current row by comparing `matrix[mid][0]` (first element) and `matrix[mid][matrix[mid].length - 1]` (last element) with the target:
     - If the target is within this range, perform a binary search on this row.
     - If the target is smaller than `matrix[mid][0]`, narrow the search to the rows above (`bottom = mid - 1`).
     - If the target is greater than `matrix[mid][matrix[mid].length - 1]`, narrow the search to the rows below (`top = mid + 1`).

2. Perform binary search within the identified row:
   - Use a standard binary search algorithm to locate the target within the row.
   - Return `true` if the target is found; otherwise, return `false`.

3. If no suitable row is found or the target is not present in the row, return `false`.

Time Complexity:
- Binary search on the rows takes O(log(m)) where `m` is the number of rows.
- Binary search within a row takes O(log(n)) where `n` is the number of columns.
- Combined complexity: O(log(m) + log(n)) -> O(log(m * n)).

Space Complexity:
- The solution uses a constant amount of extra space, resulting in O(1) space complexity.
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        while(top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return binarySearch(matrix[mid], target);
            }
            if(matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
