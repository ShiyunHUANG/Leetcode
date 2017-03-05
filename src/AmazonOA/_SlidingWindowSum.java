package AmazonOA;
/**
 * Given an array of n integer, and a moving window(size k), 
 * move the window at each iteration from the start of the array,
 * find the sum of the element inside the window at each moving.

Example

For array [1,2,7,8,5], moving window size k = 3. 
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]
 */
public class _SlidingWindowSum {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};//!corner case, num is empty
        int len = nums.length;
        int resultSize = k >= len ? 1 : len - k + 1;
        int[] res = new int[resultSize];
        int sum = 0;
        //add the first sum
        for(int i = 0; i < Math.min(k, len); i++) {
            sum += nums[i];
        }
        res[0] = sum;
        for(int i = k; i < len; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            res[i - k + 1] = sum;
        }
        return res;
        //can also use Queue, but would need extra space
    }
}
