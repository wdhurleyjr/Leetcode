/*
Notes:

Time Complexity: O(N * K), where N is the number of strings in the input array `strs` and K is the average length of a string.
Space Complexity: O(N * K), for storing the grouped anagrams in the hashmap and the resulting list.

This solution groups anagrams together using a character frequency count as the key in a hashmap.

Algorithm Explanation:
1. Create a hashmap (`map`) to store the grouped anagrams:
   - The key is a string representation of the character frequency count.
   - The value is a list of strings (anagrams).

2. Iterate through each string in the input array:
   - For each string, create an array of size 26 (`arr`) to store the frequency of each character.
   - For every character in the string, increment the corresponding position in `arr` based on its ASCII value relative to 'a'.
   - Convert the frequency array (`arr`) to a string using `Arrays.toString()` to use as the key.

3. Add the string to the hashmap:
   - If the key does not exist in the hashmap, initialize a new list.
   - Add the current string to the list corresponding to its key.

4. Return the grouped anagrams:
   - Convert the hashmap values to a list of lists and return it.

Key Points:
- The key idea is to represent each anagram group by a unique character frequency signature.
- `Arrays.toString()` creates a consistent string representation of the character frequency array, ensuring anagrams map to the same key.
- Efficient use of a hashmap allows quick lookups and grouping of strings.
- Handles edge cases like empty strings and single-character strings gracefully.
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] arr = new int[26];
            for(int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }
            String key = Arrays.toString(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}