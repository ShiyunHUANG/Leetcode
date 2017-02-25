package medium;
import java.util.Arrays;

public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        /**
         * Bit manipulation method.
         * a^b^b == a;
         */
        int XOR = nums.length;//because in the loop this number does not get ^
        for (int i = 0; i < nums.length; i++) {
            XOR ^= i;
            XOR ^= nums[i];
        }
        System.out.println(0^0^1^2^2^3^3);//1
        return XOR;
        /*if (nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] % 2 == 0) return nums[0] + 1;
            else return nums[0] - 1;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        for(int i = 0,j = nums.length - 1; i <= j + 1; i++, j--) {
            if (nums[i] != i) return nums[i] - 1;
            if (nums[j] != max) return nums[j] + 1;
            max--;
        }
        return nums[nums.length - 1] + 1;*/
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
