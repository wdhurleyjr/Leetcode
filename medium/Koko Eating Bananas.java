/*
Notes:

Time Complexity: O(n log m)
- The binary search operates over a range of possible eating speeds (1 to max(piles)), contributing O(log m).
- For each mid value, the `canEatAll` function iterates through the `piles` array, contributing O(n) per iteration.
- Overall, the time complexity is O(n log m), where n is the size of `piles` and m is the maximum value in `piles`.

Space Complexity: O(1)
- The solution operates in constant space. No additional data structures are used that grow with input size.

Approach:
1. Binary Search for Minimum Eating Speed:
   - The problem requires finding the smallest integer `k` (eating speed) such that all bananas can be eaten in `h` hours.
   - The range for binary search is `[1, max(piles)]`, where `max(piles)` is the maximum pile size since eating more than the largest pile per hour is unnecessary.

2. Helper Function: `canEatAll`:
   - This function checks if a given eating speed `k` allows all bananas to be eaten within `h` hours.
   - For each pile, that amount of k needed and added to the overall count.
   - The total hours required are accumulated, and the function returns `true` if the total hours are less than or equal to `h`.

3. Helper Function: `findMax`:
   - This function finds the maximum value in the `piles` array. It determines the upper bound for the binary search.

4. **Binary Search Logic**:
   - Calculate the middle point `mid` of the current search range.
   - If `canEatAll(mid)` returns `true`, update `minK` to the smaller value between `minK` and `mid` and adjust the right bound to `mid - 1`.
   - Otherwise, adjust the left bound to `mid + 1`.
   - Continue until the bounds converge.

5. Return Result:
   - After the binary search completes, `minK` contains the minimum eating speed that satisfies the constraints.

Edge Cases:
- Single pile: The eating speed is equal to the size of the pile.
- Very large piles with very few hours: Forces higher eating speeds.
- Multiple piles with exactly `h` hours: Tests the binary search efficiency.
*/


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minK = 1000000001;
        int max = findMax(piles);
        int left = 1;
        int right = max;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canEatAll(piles, mid, h)) {
                minK = Math.min(minK, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minK;
    }
    private boolean canEatAll(int[] piles, int k, int h) {
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            int countPer = (int) Math.ceil(1.0 * piles[i] / k);
            count += countPer;
        }
        return count <= h;
    }
    private int findMax(int[] piles) {
        int max = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
}
