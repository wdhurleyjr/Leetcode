/*
Notes:

Time Complexity: O(log n)
Space Complexity: O(1)

This solution uses binary search to efficiently determine the correct number in the range [1, n]. The problem is structured such that a helper function `guess(int num)` provides feedback on whether the guessed number is too high, too low, or correct.

Algorithm Explanation:
1. Initialize two pointers:
   - `left` starts at 1 (the smallest possible number).
   - `right` starts at n (the largest possible number).

2. Perform binary search:
   - Calculate the midpoint `mid` to split the range into two halves.
   - Call `guess(mid)`:
     - If `guess(mid) == 0`: The guessed number is correct, return `mid`.
     - If `guess(mid) == -1`: The target number is smaller than `mid`, so update the upper bound `right = mid - 1`.
     - If `guess(mid) == 1`: The target number is larger than `mid`, so update the lower bound `left = mid + 1`.

3. Continue narrowing the range until `left > right`. The correct number is found during the process.

Key Points:
- The midpoint calculation `mid = left + (right - left) / 2` avoids integer overflow, which can occur with `(left + right) / 2`.
- Binary search ensures logarithmic time complexity by halving the search range in each iteration.
- The space complexity is constant, as no additional data structures are used.

Edge Cases:
- When `n` is 1, the loop executes once, returning the correct number.
- The function assumes the `guess` method behaves as specified and always returns valid results.
*/


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(guess(mid) == 0) {
                return mid;
            }
            if(guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}