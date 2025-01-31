/*
Notes:

Time Complexity: O(n)
- We iterate through each character in the input string `address` once.
- Each operation (either appending a character or appending "[.]") takes constant time O(1).
- Therefore, the overall time complexity is O(n), where n is the length of the input string.

Space Complexity: O(n)
- We use a `StringBuilder` to store the output, which can hold up to `n + 2m` characters, where `m` is the number of dots in the input string.
- The space complexity is effectively O(n) because the extra characters added do not affect the asymptotic complexity.

Algorithm Explanation:
1. Initialize a `StringBuilder` to store the transformed address.
2. Iterate through each character in the input string `address`:
   - If the current character is a dot (`.`), append the string "[.]" to the `StringBuilder`.
   - If the current character is not a dot, append the character itself to the `StringBuilder`.
3. After processing all characters, convert the `StringBuilder` to a string using `toString()`.
4. Return the final defanged IP address string.

Example Walkthrough:
Input: "192.168.1.1"
Steps:
- Character '1': Append '1'
- Character '9': Append '9'
- Character '2': Append '2'
- Character '.': Append "[.]"
- Repeat for all characters.
Output: "192[.]168[.]1[.]1"
*/


class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}