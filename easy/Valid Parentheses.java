/*
Notes:

Time Complexity: O(n)
Space Complexity: O(n)

This solution uses a stack to determine if the input string of parentheses, brackets, and braces is valid.
The string is valid if:
- Every opening bracket has a corresponding closing bracket of the correct type.
- Brackets are closed in the correct order.

Algorithm Explanation:
1. Iterate through each character in the string.
   - If the character is an opening bracket ('(', '[', '{'), push it onto the stack.
   - If the character is a closing bracket (')', ']', '}'):
     - Check if the stack is empty. If so, return false because there is no opening bracket to match.
     - Compare the closing bracket to the opening bracket on top of the stack (using `switchChar` to get the expected opening bracket).
     - If they don't match, return false.
     - Otherwise, pop the top of the stack.

2. After iterating through the string, check if the stack is empty.
   - If the stack is not empty, return false because there are unmatched opening brackets.
   - If the stack is empty, return true.

Key Helper Method:
- `switchChar`: This method maps each closing bracket to its corresponding opening bracket.
  - If a closing bracket is passed as input, it returns the expected opening bracket.
  - If an invalid character is encountered, it returns `null`.

Edge Cases:
- Empty string: Return true because there are no unmatched brackets.
- Single closing bracket (e.g., ")"): Return false because there is no matching opening bracket.
- Mixed brackets (e.g., "{[()]}"): Return true if properly nested; otherwise, return false.

Strengths:
- Simple and modular logic with a helper function (`switchChar`) for better readability.
- Handles edge cases gracefully.

Limitations:
- Assumes the input string contains only valid bracket characters. For other characters, it may not behave as expected.
*/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                if(switchChar(s.charAt(i)) != stack.peek()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private Character switchChar(Character x) {
        if(x == '}') return '{';
        if(x == ')') return '(';
        if(x == ']') return '[';
        return null;
    }
}