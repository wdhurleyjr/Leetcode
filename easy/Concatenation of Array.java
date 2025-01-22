/*
Notes:

Time Complexity: O(n)
- The algorithm iterates through the input array `nums` once, assigning elements to the new array `arr`. Each assignment is an O(1) operation, resulting in an overall linear time complexity.

Space Complexity: O(n)
- A new array `arr` of size `2 * nums.length` is created to store the concatenated result. The space required grows linearly with the size of the input array.

Algorithm Explanation:
1. **Initialize New Array**:
   - Create a new array `arr` with size `2 * nums.length` to hold the concatenated result.

2. **Iterate Through Input Array**:
   - Loop through the elements of `nums` using index `i`.
   - Assign the element `nums[i]` to `arr[i]` (first copy of the input array).
   - Assign the same element `nums[i]` to `arr[j]`, where `j` starts at `nums.length` and increments with each iteration (second copy of the input array).

3. **Return Result**:
   - After the loop completes, `arr` contains two copies of `nums` concatenated together, and it is returned as the result.

4. **Example**:
   - Input: `nums = [1, 2, 3]`
   - Steps:
     - Initialize `arr = [0, 0, 0, 0, 0, 0]`
     - Assign values during iteration:
       - `i = 0`: `arr = [1, 0, 0, 1, 0, 0]`
       - `i = 1`: `arr = [1, 2, 0, 1, 2, 0]`
       - `i = 2`: `arr = [1, 2, 3, 1, 2, 3]`
   - Output: `[1, 2, 3, 1, 2, 3]`

Key Considerations:
- The variable `j` simplifies the indexing for the second copy of `nums`, making the loop concise and easy to understand.
- This approach ensures efficient copying of elements without additional iterations or nested loops.
*/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[2 * nums.length];
        int j = nums.length;
        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[j] = nums[i];
            j++;
        }
        return arr;
    }
}