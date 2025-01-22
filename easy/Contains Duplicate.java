/*
Notes:

Time Complexity: O(n)
- The algorithm iterates through the array `nums` once, and each operation (checking membership and adding elements to the set) is O(1) on average. Thus, the overall time complexity is linear.

Space Complexity: O(n)
- A `HashSet` is used to store unique elements from the array. In the worst case (no duplicates), the set will contain all the elements of the array, requiring O(n) additional space.

Algorithm Explanation:
1. **Use a HashSet**:
   - A `HashSet` is used to efficiently track elements already seen in the array. The `HashSet` provides constant-time operations for checking membership and adding elements.

2. **Iterate Through Array**:
   - Loop through the elements of `nums` using index `i`.
   - For each element:
     - Check if it already exists in the set using `set.contains(nums[i])`.
     - If it exists, return `true`, indicating a duplicate is found.
     - If it does not exist, add the element to the set using `set.add(nums[i])`.

3. **Return Result**:
   - If the loop completes without finding a duplicate, return `false`, indicating all elements are unique.

4. **Example**:
   - Input: `nums = [1, 2, 3, 4, 5]`
     - `set = {}` initially.
     - Elements are added one by one. No duplicates are found, so the output is `false`.
   - Input: `nums = [1, 2, 3, 4, 2]`
     - On encountering the second `2`, `set.contains(2)` is `true`, so the output is `true`.

Key Considerations:
- This approach efficiently handles the problem due to the properties of the `HashSet`.
- The algorithm works well for arrays of any size and ensures duplicates are detected in linear time.
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}