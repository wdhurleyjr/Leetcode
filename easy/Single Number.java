/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This solution uses the XOR (^) bitwise operation to find the single number in an array where
every number appears twice except for one. XOR is a powerful operation for this problem because
of its unique properties:
1. `a ^ a = 0` - Any number XORed with itself results in 0.
2. `a ^ 0 = a` - Any number XORed with 0 remains unchanged.
3. XOR is commutative and associative, meaning the order of operations doesn't matter.

Algorithm:
1. Initialize `result` to 0.
2. Iterate through the array, XORing each element with `result`.
   - Duplicate numbers will cancel each other out due to the property `a ^ a = 0`.
   - Only the unique number will remain in `result` after all XOR operations.
3. Return `result`, which will hold the single number.

Key Features:
- Efficient in both time and space:
  - Time Complexity: O(n) - The array is traversed once.
  - Space Complexity: O(1) - The solution uses a single variable `result`.

Example:
Input: nums = [4, 1, 2, 1, 2]
Steps:
- `result = 0 ^ 4 = 4`
- `result = 4 ^ 1 = 5`
- `result = 5 ^ 2 = 7`
- `result = 7 ^ 1 = 6`
- `result = 6 ^ 2 = 4`
Output: 4 (The single number is 4)

This approach is optimal because it avoids additional space usage and unnecessary sorting operations,
directly leveraging XOR to isolate the unique number.
*/

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
