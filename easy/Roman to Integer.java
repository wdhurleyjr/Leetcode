/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1) (assuming the map size is constant and does not grow dynamically)

This solution converts a Roman numeral string to its integer representation using the following approach:

Algorithm Explanation:
1. **Mapping Roman Numerals**:
   - A `HashMap` is used to store the values of Roman numeral characters ('I', 'V', 'X', etc.) for quick lookup.

2. **Iterating from Right to Left**:
   - Start traversing the string from right to left. This allows easy handling of cases where subtraction is required (e.g., "IV", "IX").
   - Maintain a `previous` variable to keep track of the Roman numeral character processed in the previous iteration.

3. **Adding or Subtracting Values**:
   - If the current Roman numeral should be subtracted (e.g., 'I' in "IV"), check if the current character is smaller than the `previous` character (e.g., 'I' < 'V').
     - Subtraction cases:
       - 'I' before 'V' or 'X' → subtract 1.
       - 'X' before 'L' or 'C' → subtract 10.
       - 'C' before 'D' or 'M' → subtract 100.
   - Otherwise, add the value of the current Roman numeral to the total and update the `previous` character.

4. **Returning the Total**:
   - After processing all characters, the `total` contains the integer equivalent of the Roman numeral string.

Example Walkthrough:
Input: s = "MCMXCIV" (1994)
- Process from right to left:
  - 'V' → Add 5 → total = 5, previous = 'V'.
  - 'I' → Subtract 1 (before 'V') → total = 4, previous = 'I'.
  - 'C' → Add 100 → total = 104, previous = 'C'.
  - 'X' → Subtract 10 (before 'C') → total = 94, previous = 'X'.
  - 'M' → Add 1000 → total = 1094, previous = 'M'.
  - 'C' → Subtract 100 (before 'M') → total = 994, previous = 'C'.
  - 'M' → Add 1000 → total = 1994, previous = 'M'.
Output: 1994

Key Insights:
- By processing the string in reverse, the algorithm simplifies handling of subtraction rules.
- The use of a `HashMap` ensures constant-time lookups for Roman numeral values.
- The algorithm efficiently handles both addition and subtraction cases without extra data structures.
*/


class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char previous = '.';
        int total = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if((s.charAt(i) == 'I' && (previous == 'V' || previous == 'X'))) {
                total -= map.get('I');
            } else if((s.charAt(i) == 'X' && (previous == 'L' || previous == 'C'))) {
                total -= map.get('X');
            } else if((s.charAt(i) == 'C' && (previous == 'D' || previous == 'M'))) {
                total -= map.get('C');
            } else {
                total += map.get(s.charAt(i));
                previous = s.charAt(i);
            }
        }
        return total;
    }
}