/*
Notes:

Time Complexity: O(n)
Space Complexity: O(n)

This solution finds the top `k` most frequent elements in an array using a frequency map and bucket sort technique.

Algorithm:
1. **Count Frequencies**:
   - Use a `HashMap` to store the frequency of each element in the array (`nums`).
     - For each element in `nums`, update its frequency in the map.

2. **Create Buckets**:
   - Create an array of lists (`list`) where the index represents the frequency.
     - `list[i]` will store all elements that appear exactly `i` times.
     - Iterate through the map entries and place each element into the corresponding bucket based on its frequency.

3. **Collect Top `k` Elements**:
   - Create an empty result list (`arr`).
   - Start from the highest frequency bucket (`list.length - 1`) and move down.
   - Add elements from non-empty buckets to the result list until `k` elements have been collected.

4. **Convert the Result List to an Array**:
   - Copy the first `k` elements from the result list (`arr`) to an integer array (`result`).

5. **Return the Result**:
   - Return the array of the top `k` most frequent elements.

Key Insight:
This solution leverages the idea of bucket sort to efficiently collect the top `k` frequent elements. The algorithm runs in **O(n)** time because:
   - Counting frequencies takes **O(n)**.
   - Filling the buckets takes **O(n)**.
   - Collecting elements from the buckets takes **O(n)** in the worst case.

The space complexity is **O(n)** due to the `HashMap` and the array of lists used for bucket sorting.
*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        for(int num : map.keySet()) {
            int freq = map.get(num);
            list[freq].add(num);
        }
        List<Integer> arr = new ArrayList<>();
        for(int m = list.length - 1; m >= 0 && arr.size() < k; m--) {
            if(!list[m].isEmpty()) {
                arr.addAll(list[m]);
            }
        }
        int[] result = new int[k];
        for(int l = 0; l < result.length; l++) {
            result[l] = arr.get(l);
        }
        return result;
    }
}
