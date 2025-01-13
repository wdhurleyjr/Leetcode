/*
Notes:

Time Complexity: O(n * m)
- Where `n` is the number of strings in the array and `m` is the average length of the strings.
- Each string is compared character by character to the current longest common prefix (LCP), leading to a linear scan for each string.

Space Complexity: O(1)
- The algorithm modifies the `LCP` variable in place without requiring additional data structures.

Algorithm Explanation:
1. The algorithm assumes the first string in the array (`strs[0]`) as the initial longest common prefix (LCP).
2. It iterates through the rest of the strings in the array:
   - For each string, it compares its characters with the characters of `LCP` from left to right.
   - The comparison stops as soon as a mismatch is found or one of the strings is exhausted.
3. After identifying the common prefix between `LCP` and the current string, `LCP` is updated to the common portion using `substring`.
4. The process continues until all strings have been processed.
5. Finally, the updated `LCP` represents the longest common prefix among all strings.
*/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        String LCP = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            while (j < LCP.length() && j < str.length() && LCP.charAt(j) == str.charAt(j)) {
                j++;
            }
            LCP = LCP.substring(0, j);
        }
        return LCP;
    }
}