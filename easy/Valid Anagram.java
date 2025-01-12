/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This solution efficiently checks if two strings are anagrams by leveraging the fixed size of the alphabet (26 characters).

Key Steps:
1. **Length Check**: If the two strings have different lengths, they cannot be anagrams, so we return `false` immediately.
2. **Character Count Array**:
   - An integer array of size 26 (`arr`) is initialized to count the occurrences of each character in the strings.
   - Characters from the first string (`s`) increment the respective index in the array, while characters from the second string (`t`) decrement it.
   - The index for each character is calculated as `char - 'a'`, which maps 'a' to 0, 'b' to 1, and so on.
3. **Validation**:
   - After processing both strings, the array should contain all zeros if the strings are anagrams.
   - A final loop iterates through the array to check if any value is non-zero. If any value is non-zero, the strings are not anagrams.

Optimization:
- The array size is fixed at 26, so the space complexity is constant: O(1).
- Both loops run proportional to the length of the strings, resulting in an overall time complexity of O(n), where `n` is the length of the strings.

This approach avoids the need for sorting or additional data structures, making it both space and time efficient.
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
            if(arr[j] != 0) return false;
        }
        return true;
    }
}