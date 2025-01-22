/*
Notes:

Time Complexity: O(n)
- The algorithm iterates through the strings `s` and `t` in a single loop, incrementing and decrementing the counts in the array `arr`. This step takes O(n), where n is the length of the strings.
- Additionally, it iterates through the `arr` array of size 26 in O(1) time.
- Overall complexity is O(n).

Space Complexity: O(1)
- The solution uses a fixed-size array `arr` of size 26 to store counts for the English alphabet. This does not scale with the input size, making the space complexity constant.

Algorithm Explanation:
1. **Initial Length Check**:
   - If the lengths of `s` and `t` differ, they cannot be anagrams, so the function immediately returns `false`.

2. **Frequency Count**:
   - Create an integer array `arr` of size 26 to count occurrences of each character.
   - For each character in `s`, increment the corresponding index in `arr` (using `s.charAt(i) - 'a'` to map characters to indices).
   - For each character in `t`, decrement the corresponding index in `arr`.

3. **Validation**:
   - After processing both strings, iterate through the `arr` array.
   - If any index in `arr` has a value greater than 0, it indicates a mismatch in character frequencies between `s` and `t`, so the function returns `false`.

4. **Return Result**:
   - If all values in `arr` are zero, the strings are anagrams, and the function returns `true`.

5. **Example**:
   - Input: `s = "anagram"`, `t = "nagaram"`
     - After processing: `arr = [0, 0, 0, 0, 0, 0, ..., 0]`.
     - Output: `true`.
   - Input: `s = "rat"`, `t = "car"`
     - After processing: `arr` contains non-zero values.
     - Output: `false`.

Key Considerations:
- This approach efficiently determines if two strings are anagrams by leveraging the fixed-size nature of the English alphabet.
- It avoids sorting or using additional data structures, resulting in optimal time and space complexity.
*/


class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] > 0) return false;
        }
        return true;
    }
}