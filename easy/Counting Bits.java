/*
Time Complexity: O(n)
Space Complexity: O(1)

This solution calculates the number of 1-bits (Hamming weight) for each integer from 0 to n
using the property of `num &= (num - 1)` to count the bits efficiently.

Algorithm:
1. Create an array `arr` of size `n + 1` to store the results.
2. Iterate through all integers `i` from 0 to `n`:
   - Initialize a variable `num` with the value of `i`.
   - Use a while loop to repeatedly apply the bit manipulation operation `num &= (num - 1)` to count the 1-bits in `num`.
   - Increment a `result` counter for each operation.
   - Store the result for `i` in `arr[i]` and reset the `result` counter for the next number.
3. Return the array `arr`, where `arr[i]` contains the count of 1-bits for the integer `i`.

Time Complexity:
- Each bit in the binary representation of the numbers from `0` to `n` is processed exactly once, resulting in O(n) time complexity.

Space Complexity:
- The solution uses a single integer variable (`result`) and modifies the input array in place, leading to O(1) additional space complexity.
*/



class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        int result = 0;
        for(int i = 0; i <= n; i++) {
            int num = i;
            while(num != 0) {
                num &= num - 1;
                result++;
            }
            arr[i] = result;
            result = 0;
        }
        return arr;
    }
}