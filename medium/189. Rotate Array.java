// Notes:

// Time Complexity: O(n)
// Space Complexity: O(1)

// The approach for normalizing k with mod n is that any rotation over the length of the array
// would be extra work and decrease inefficency. Example: If there is an array of length 7 and
// k = 9, we can simply 9 % 7 = 2 giving us total of 2 rotations to solve this example. Additionally,
// we reverse the initial array using a two pointer helper function and then split the array based on
// k and reverse the two halves and solving the problem. The overall complexity is O(2n) -> O(n). 
// Lastly, the space complexity is O(1) because this problem doesnt not declare data structure that
// would grow as nums grows in size and memory. The temp variable is essentially static in this process.

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
