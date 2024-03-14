/*

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length 
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int prefixSum = 0; 
        Map<Integer, Integer> prefixSumCounts = new HashMap<>(); // Stores counts of prefix sums
        prefixSumCounts.put(0, 1); // Account for empty subarray case (sum = 0)

        for (int end = 0; end < nums.length; end++) {
            prefixSum += nums[end];

            // Check for a previously seen prefix sum that makes the current window sum = goal
            if (prefixSumCounts.containsKey(prefixSum - goal)) {
                count += prefixSumCounts.get(prefixSum - goal); 
            }

            // Update the count of the current prefix sum
            prefixSumCounts.put(prefixSum, prefixSumCounts.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

