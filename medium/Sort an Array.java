/*
Notes:

Time Complexity: O(n log n) on average, O(n^2) in the worst case.
Space Complexity: O(log n) due to recursion stack space.

This implementation uses the Quick Sort algorithm to sort an array of integers. Quick Sort is an efficient
divide-and-conquer sorting algorithm that is often used because of its average-case time complexity of O(n log n)
and its in-place sorting capability, making the space complexity minimal.

Algorithm Explanation:
1. Divide:
   - Select a pivot element (in this implementation, the last element in the range).
   - Partition the array into two subarrays: one with elements less than or equal to the pivot and another with elements greater than the pivot.

2. Conquer:
   - Recursively apply the same process to the subarrays created by partitioning.

3. Combine:
   - The array is fully sorted once all recursive calls complete.

Key Functions:
- `partition`:
   - Rearranges elements in the array such that all elements less than or equal to the pivot are to its left, and all elements greater are to its right.
   - Returns the index of the pivot element after partitioning.
- `swap`:
   - Swaps two elements in the array.

Advantages:
- Quick Sort is an in-place sorting algorithm, meaning it doesn't require extra space for a new array, reducing space complexity to O(log n) for the recursion stack.
- It is generally faster than other O(n log n) algorithms like Merge Sort due to lower overhead.

Disadvantages:
- The worst-case time complexity of O(n^2) occurs when the pivot selection is poor (e.g., always selecting the smallest or largest element).

Use Case:
- Suitable for scenarios requiring in-place sorting with average-case efficiency. Less ideal for already sorted or nearly sorted arrays without optimization (e.g., using random pivot selection or three-way partitioning).
*/

class Solution {
    public int[] sortArray(int[] nums) {
        // use heap, quick, or merge sort.
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private int[] quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
        return nums;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, high, i + 1);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}