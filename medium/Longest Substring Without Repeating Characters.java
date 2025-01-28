/*
Notes:

Time Complexity: O(n)
Space Complexity: O(k), where k is the size of the character set (e.g., 26 for lowercase English letters or 128 for ASCII).

This solution finds the length of the longest substring without repeating characters using the sliding window technique.

Algorithm:
1. Use a `HashSet` to keep track of the characters in the current substring.
   - The `HashSet` ensures that we can check for duplicates in O(1) time.
2. Maintain two pointers:
   - `l` (left pointer): Tracks the start of the current substring.
   - `r` (right pointer): Tracks the current character being processed.
3. Iterate through the string (`s`) using a for-loop:
   - If the character at the current index `i` is already in the `HashSet`, shrink the window from the left:
     - Remove `s.charAt(l)` from the `HashSet` and increment `l` to move the left pointer forward.
   - Add `s.charAt(i)` to the `HashSet` to include the new character in the substring.
   - Update `r` to the maximum length of the current substring (`i - l + 1`).
4. Return the value of `r`, which represents the length of the longest substring without repeating characters.

Key Insight:
The sliding window technique ensures that each character is added to and removed from the `HashSet` at most once, making the algorithm run in O(n) time. The `HashSet` provides efficient duplicate detection, while the two-pointer approach dynamically adjusts the window size, keeping the solution both time and space efficient.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            r = Math.max(r, i - l + 1);
        }
        return r;
    }
}