/*
Notes:

Time Complexity: O(n)
Space Complexity: O(n)

This solution encodes and decodes a list of strings using a delimiter (`#`) to separate the length of each string from its contents. It handles different string lengths and ensures that strings can be correctly reconstructed during decoding.

---

**Encoding Algorithm:**
1. Initialize an empty `StringBuilder` (`sb`).
2. For each string in the input list (`strs`):
   - Append the length of the string, followed by the delimiter `#`.
   - Append the string itself to the `StringBuilder`.
3. Return the final encoded string.

**Example (Encoding):**
- Input: `["leet", "code"]`
- Process:
  - `"leet"` → `4#leet`
  - `"code"` → `4#code`
- Encoded string: `"4#leet4#code"`

---

**Decoding Algorithm:**
1. Initialize an empty list (`list`) to store decoded strings.
2. Use a pointer (`i`) to traverse the encoded string (`str`):
   - Set a second pointer (`j`) to find the next `#` delimiter.
   - Parse the length of the string from `str.substring(i, j)`.
   - Move the pointer `i` to the start of the actual string (`j + 1`).
   - Extract the string using `str.substring(i, i + length)`.
   - Add the extracted string to the result list.
   - Update `i` to point to the next length prefix.
3. Repeat until the entire encoded string is processed.
4. Return the result list.

**Example (Decoding):**
- Input: `"4#leet4#code"`
- Process:
  - Read `4` → Extract `"leet"`
  - Read `4` → Extract `"code"`
- Output: `["leet", "code"]`

---

**Key Insight:**
This solution efficiently handles encoding and decoding without ambiguity by using a length prefix and delimiter. It ensures that even strings containing special characters (including `#`) can be correctly encoded and decoded. The time complexity is **O(n)** because both encoding and decoding involve linear scans through the input strings.

*/

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            list.add(str.substring(i, j));
            i = j;
        }
        return list;
    }
}
