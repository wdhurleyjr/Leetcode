// Notes:

// Time Complexity: O(n)
// Space Complexity: O(1)
//
// The approach for normalizing k with mod n ensures we avoid redundant rotations.
// Rotating the array more than its length is unnecessary and inefficient. For example,
// if we have an array of length 7 and k = 9, we can simplify the problem by calculating
// k = 9 % 7 = 2. This reduces the rotations needed to just 2, achieving the same result.
//
// The solution involves three steps:
// 1. Reverse the entire array using a two-pointer helper function.
// 2. Reverse the first k elements to position the rotated portion correctly.
// 3. Reverse the remaining n - k elements to complete the rotation.
//
// The overall complexity is O(2n) -> O(n) because each reversal operation is linear in time.
//
// Lastly, the space complexity is O(1) since the solution modifies the array in place.
// No additional data structures are used that grow with the size of the input.
// The temporary variable used in the helper function (`temp`) is constant in size and does
// not depend on the input length, ensuring the memory usage remains constant.

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
