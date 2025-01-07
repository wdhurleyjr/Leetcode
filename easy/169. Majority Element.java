// Notes:

// Time Complexity: O(n)
// Space Complexity: O(1)

// This solution uses the Boyer-Moore Voting Algorithm to find the majority element efficiently.
// The problem guarantees that the majority element appears more than floor(n/2) times.
// For example, in an array of length 5, the majority element must appear more than floor(5/2) = 2 times.
// This property ensures that a majority element will dominate the count throughout the process.

// Algorithm Explanation:
// 1. The algorithm initializes a `majorityElement` and a `count`.
// 2. It iterates through the array, updating the `majorityElement` whenever the `count` reaches 0.
// 3. The `count` is incremented if the current element matches the `majorityElement` and decremented otherwise.
// 4. At the end of the loop, the `majorityElement` is guaranteed to be the element that appears the most,
//    based on the problem's constraints.

// Assumptions:
// - This algorithm assumes the input satisfies the problem's guarantee that a majority element exists.
// - If this guarantee is not present, an additional verification step would be required.

class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majorityElement = nums[i];
            }
            count += (nums[i] == majorityElement) ? 1 : -1;
        }
        return majorityElement;
    }
}
