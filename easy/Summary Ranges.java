/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1) (excluding the output list)

This solution generates a summary of ranges from a sorted array of integers in a single pass using a greedy approach.

Algorithm:
1. Handle edge cases:
   - If the array is empty, return an empty list.

2. Use a `for` loop to iterate over the array (`nums`):
   - Define `start` to mark the beginning of a range.
   - Continue moving through the array as long as consecutive elements follow the pattern `nums[i] + 1 == nums[i + 1]`.
     - This defines a continuous sequence of numbers.

3. When the sequence ends:
   - Set `end` to the last element of the range.
   - Add the range to the list:
     - If the range has only one number (`start == end`), add it as a single value (e.g., `"1"`).
     - If the range has multiple numbers (`start != end`), add it in the format `"start->end"` (e.g., `"1->3"`).

4. Continue iterating through the array until all ranges are processed.

5. Return the list of ranges as the result.

Key Insight:
This solution leverages a **start-end pattern** to efficiently identify and summarize continuous ranges in a single traversal. By making decisions as it goes, the algorithm avoids any need for backtracking or extra storage beyond the output list. The time complexity is O(n), where `n` is the size of the input array, and the space complexity is O(1) (excluding the result list).
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            StringBuilder sb = new StringBuilder();
            int start = i;
            while(i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            int end = i;
            if(start == end) {
                sb.append(nums[start]);
                list.add(sb.toString());
            } else {
                sb.append(nums[start]).append("->").append(nums[end]);
                list.add(sb.toString());
            }
            i++;
        }
        return list;
    }
}