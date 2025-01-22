/*
Notes:

Time Complexity: O(n)
- The algorithm iterates through the input array once, performing a constant-time `containsKey` and `put` operation on the HashMap for each element. This results in a linear time complexity.

Space Complexity: O(n)
- A HashMap is used to store the elements of the array along with their indices. In the worst case, all elements are stored, leading to O(n) space complexity.

Algorithm Explanation:
1. **Initialize HashMap**:
   - A HashMap `map` is used to store numbers from the array as keys and their respective indices as values.

2. **Iterate Through Array**:
   - For each element `num` in the array at index `i`:
     - Calculate the difference `diff = target - num`.
     - Check if `diff` exists in the HashMap:
       - If yes, it means a pair of numbers `(num, diff)` has been found such that `num + diff = target`.
       - Return the indices of `diff` (from the HashMap) and `num` (current index `i`).
     - If `diff` does not exist in the HashMap, add `num` and its index `i` to the HashMap.

3. **Edge Case**:
   - If no pair is found by the end of the loop, return an empty array. This handles cases where no solution exists.

Key Considerations:
- The use of a HashMap ensures efficient lookups for the difference in O(1) time.
- The algorithm assumes exactly one solution exists as per the problem statement.
- No duplicate pairs are stored, as each element is processed only once.
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(num, i);
        }
        return new int[]{};

    }
}