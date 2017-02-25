package easy;

public class TotalHammingDistance477 {
    /*
    a = 0 0 0 1 0
    b = 1 0 0 1 1
    c = 0 1 0 0 1
    d = 1 0 0 1 0
    e = 0 0 0 1 0
                ↑
    digit 1: b, c
    digit 0: a, d, e

    pairs that make distance are:
    b: a, d, e
    c: a, d, e

    total distance = 2 * 3
    then we move the pointer one position left, i.e. all the number right shift >>>

     */
    public int totalHammingDistance(int[] nums) {
        int res = 0, len = nums.length;
        for(int i = 0; i < 32; i++) { //loop through the 32 digits in integers
            int ones = 0;
            for(int j = 0; j < len; j++) { //can not use for(int n : nums), because cannot assign
                if((nums[j] & 1) == 1) ones++;
                nums[j] = nums[j] >>> 1;
            }
            res = res + ones * (len - ones);
        }
        return res;
    }
    /**Brute force TLE solution*/
    public int totalHammingDistance2(int[] nums) {
        int res = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                res = res + Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
