/*
Notes:

Time Complexity: O(n)
- `trim()` scans the entire string to remove leading and trailing whitespace, taking O(n) time.
- The loop iterates through the last word, also taking O(n).
- Total time complexity is O(n).

Space Complexity: O(1)
- Only integer variables are used, resulting in constant space usage.

Algorithm Explanation:
1. **Trim the string:** Removes extra whitespace at the beginning and end.
2. **Reverse iteration:** Start from the last character, counting non-space characters until a space or the start of the string is reached.
3. **Return the result:** The final count is the length of the last word.

Example:
- Input: `"   Hello World   "`
  - After trimming: `"Hello World"`.
  - Loop counts 5 characters in `"World"`.
  - Output: `5`.

Edge Cases:
- Input: `" "` → Returns `0`.
- Input: `"a "` → Returns `1`.

Elegance:
- Simple, efficient, and handles edge cases well. The combination of `trim()` and reverse traversal makes the solution clean and maintainable.
*/


class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }
}