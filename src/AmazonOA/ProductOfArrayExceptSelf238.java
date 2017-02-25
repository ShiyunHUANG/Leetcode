package AmazonOA;

public class ProductOfArrayExceptSelf238 {
    //Two loops
    public int[] productExceptSelf2(int[] nums) {
        if(nums == null) return null; 
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;
        res[0] = 1;
        int a = 1; //product
        for(int i = 1; i < nums.length; i++) {
            a *= nums[i - 1];
            res[i] = a;
        }
        int b = 1; //product
        for(int j = nums.length - 2; j >= 0; j--) {
            b *= nums[j + 1];
            res[j] *= b;
        }
        return res;
    }
    
    
    //over time limit
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int ele;        
        for (int i = 0 ; i < nums.length; i++) {
            ele = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                ele = ele * nums[j];
            }            
            res[i] = ele;
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
