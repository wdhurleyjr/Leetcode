/*
Notes:

Time Complexity: O(k)
Space Complexity: O(1)

This solution calculates the Hamming Weight (number of `1` bits) by leveraging bit manipulation.
It repeatedly removes the rightmost `1` bit in the binary representation of the integer using the
operation `n &= (n - 1)`.

Algorithm:
1. Initialize a counter (`result`) to track the number of `1` bits.
2. While `n` is not zero:
   - Subtract `1` from `n`, which flips all bits after the rightmost `1` (including the `1` itself).
   - Perform `n &= (n - 1)` to remove the rightmost `1` bit.
   - Increment the counter.
3. Return the counter after all `1` bits are removed.

Key Insight:
The operation `n &= (n - 1)` removes one `1` bit per iteration, making the loop run in O(k),
where `k` is the number of `1` bits in `n`. This is more efficient than processing all 32 bits
of the integer. Space complexity remains O(1) as no extra data structures are used.
*/

class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }
}

/* This solution is still done in constant time O(32) but it deals with the right most bit then
   shifts the bits to the right effectively overwritting the original least significant bit. The
   modulo operator is used to determine if the new LSB is a 1 or 0 and increments the result count.
   Then result is returned with the total number of 1 bits in the integer.
 */


class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int num = n % 2;
            if(num == 1) result++;
            n >>= 1;
        }
        return result;
    }
}