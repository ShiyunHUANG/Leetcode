package easy;

public class RemoveDuplicatesFromASortedArray26 {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        if (res == 1) {
            return 1;
        }
        int pointer1 = 0;
        int pointer2 = 1;
        while(pointer2 < nums.length) {
            System.out.println("now pointer1 is at: " + pointer1 + " , pointer2 is at: " + pointer2);
            while (nums[pointer1] == nums[pointer2]) {
                pointer2++;
                res--;
                if (pointer2 > nums.length - 1) {
                    System.out.println("getting out because I reach the end and I am now at: " + pointer2 );
                    return res;//!!!
                }
                
            }
            //the number before pointer2 is duplicate. if pointer2 is out of bound, all element same
            if (pointer2 > pointer1 + 1) {
                System.out.println("swaping idx at " + (pointer1+1) + " with " + pointer2);
                nums[pointer1 + 1] = nums[pointer2];
            }
            pointer1++;
            pointer2++;
        }
        return res;
    }
    public static void main(String[] args) {
    }

}
