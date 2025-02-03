/*
Notes:

Time Complexity: O(n + m)
- `n` is the length of string `s`, and `m` is the length of string `t`.
- The algorithm iterates through both strings once, making the time complexity O(n + m).

Space Complexity: O(1)
- The solution uses only a few integer variables (`i`, `j`), resulting in constant space usage.

Algorithm Explanation:
1. **Edge case check:** If `s` is longer than `t`, it can't be a subsequence, so return `false`.
2. **Two-pointer approach:**
   - Use `i` to track characters in `s` and `j` to track characters in `t`.
   - If `s.charAt(i)` matches `t.charAt(j)`, move `i` to the next character.
   - Always increment `j` to continue checking the next character in `t`.
3. **Check result:** If `i` reaches the end of `s`, all characters in `s` were found in `t` in order, so return `true`.

Example:
- Input: `s = "abc", t = "ahbgdc"`
  - Matching characters: `'a'`, `'b'`, `'c'`
  - `i` reaches the end of `s`, so the output is `true`.
- Input: `s = "axc", t = "ahbgdc"`
  - `'x'` is not found in `t`, so the output is `false`.

Edge Cases:
- Input: `s = ""` → Always returns `true`.
- Input: `t = ""` → Returns `false` unless `s` is also empty.

Elegance:
- The two-pointer technique is simple and efficient, making the solution easy to understand and maintain.
*/


class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while(j < t.length() && i < s.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}