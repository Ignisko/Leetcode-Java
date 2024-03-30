import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int count = 0, left = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int right = 0; right < nums.length; ++right) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) k--;
            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) k++;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
