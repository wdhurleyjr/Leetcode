/*
Notes:

Time Complexity: O(log x)
Space Complexity: O(1)

This solution uses a binary search approach to find the square root of a non-negative integer x, returning the truncated integer part of the result if x is not a perfect square.

Algorithm Explanation:
1. Handle the edge case where x < 2:
   - If x is 0 or 1, the square root is x itself.
2. Initialize two pointers:
   - `left` starts at 0.
   - `right` starts at x.
3. Perform a binary search:
   - Calculate the midpoint `mid`.
   - Check if `mid * mid` equals x:
     - If true, return `mid` as the square root.
   - If `mid * mid` is greater than x:
     - Narrow the search range by moving `right` to `mid - 1`.
   - Otherwise, move `left` to `mid + 1`.
4. When the loop exits, the closest integer less than or equal to the square root is stored in `right`.
   - Return `right` as the truncated square root.

Key Points:
- The use of `(long)mid * mid` ensures there is no overflow during multiplication.
- Binary search is efficient with a logarithmic time complexity, repeatedly halving the search range until the result is found.
- Space complexity is constant since the algorithm operates in place without additional data structures.
*/

class Solution {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if((long)mid * mid == x) {
                return mid;
            }
            if((long)mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}