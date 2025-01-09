/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This approach rotates the array in-place using a three-step process, leveraging
the properties of reversing subarrays. The key optimization is normalizing `k`
using `k % n`, which avoids unnecessary rotations. For example, in an array of
length 7 and k = 9, we calculate k = 9 % 7 = 2, reducing the problem to just 2
rotations while achieving the same result.

Algorithm Steps:
1. Reverse the entire array using a two-pointer helper function.
2. Reverse the first k elements to position the rotated portion correctly.
3. Reverse the remaining n - k elements to complete the rotation.

Complexity Analysis:
- Time Complexity: O(2n) -> O(n), as the three reversals each take linear time.
- Space Complexity: O(1), since the array is modified in place without allocating
  additional data structures. The helper function uses a single temporary variable (`temp`),
  ensuring constant memory usage.

Key Assumptions:
- The input array is non-empty, and k is non-negative.
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
