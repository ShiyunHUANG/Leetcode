package easy;

public class RangeSumQueryImmutable303 {
    int [] nums;
    int [] sum;//can delete this. just directly modify nums[]
    public RangeSumQueryImmutable303 (int[] nums){
        this.nums = nums;
        if (nums.length == 0) {
            return;
        }
        sum = new int [nums.length];
        sum[0] = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            sum[idx] = nums[idx] + sum[idx - 1];
            System.out.println("sum" + idx + ": " +sum[idx]);
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];//can use if to check if i == 0 , if not, directly use sum[j] - sum[i];
    }
    public static void main(String[] args) {
        RangeSumQueryImmutable303 x = new RangeSumQueryImmutable303( new int[] {-2,0,3,-5,2,-1});
        System.out.println(x.sumRange(0, 2));
        System.out.println(x.sumRange(2, 5));
        System.out.println(x.sumRange(0, 5));
    }

}
