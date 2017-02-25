package medium;

public class MinimumSizeSubarraySum209 {
    /**Others solution*/
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0)
          return 0;
        int a = 0, b = 0, sum = 0, min = Integer.MAX_VALUE;
        while (b < nums.length) {
          sum = sum + nums[b];
          b++;
          while (sum >= s) {
            min = Math.min(min, b - a);
            sum = sum - nums[a];
            a++;
          }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
      }
    /**My Solution*/
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length + 1;
        if(nums.length == 0) return 0;
        int a = 0, b = 0, sum = nums[a];
        while(b < nums.length) {
            System.out.println("a " + nums[a] + " b " + nums[b] + " res " + res + " sum " + sum);
            if(sum >= s) {
                while(sum - nums[a] >= s) {
                    sum = sum - nums[a];
                    a++;
                }
                res = Math.min(res, b - a + 1);
                b++;
                if (b < nums.length) {
                    sum = sum - nums[a] + nums[b];
                    a++;
                }
            }
            else {
                b++;
                if(b < nums.length) sum = sum + nums[b];//!!!pay attention to this position
                else if(sum < s && res == nums.length + 1) return 0;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        MinimumSizeSubarraySum209 x = new MinimumSizeSubarraySum209();
        int[] test = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int[] test2 = new int[]{1,2,3,4,5};
        System.out.println(x.minSubArrayLen(15, test2));
    }
}
