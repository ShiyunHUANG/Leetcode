package medium;

public class SearchForARange34 {
    public int[] searchRange(int[] nums, int target) {
        int res1 [] = search(0, nums.length - 1, target, nums);
        if (res1[0] == -1) {
            return new int[] {-1, -1};
        }
        
        int left = res1[1];
        int res2[] = new int[] {res1[0], res1[1], res1[2]};
        while (left >= 0 ) {
            int [] temp = search(left, res2[0] - 1, target, nums);//the second para is res2 not res1 (res1 don't change)
            if (temp[0] == -1) {
                break;
            }
            res2 = temp;
            left = res2[1];
            System.out.println("res2: " + res2[0] + ", " + res2[1] + ", " + res2[2]);
        }
        
        int right = res1[2];
        int res3[] = new int[] {res1[0], res1[1], res1[2]};
        while (right <= nums.length - 1) {
            int [] temp = search(res3[0] + 1, right, target, nums);//the first para is res2 not res1 (res1 don't change)
            if (temp[0] == -1) {
                break;
            }
            res3 = temp;
            right = res3[2];
            System.out.println("res3: " + res3[0] + ", " + res3[1] + ", " + res3[2]);
        }
        return new int[] {res2[0], res3[0]};
    }
    private int[] search(int low, int high, int target, int[] nums) {
        if (low > high) {
            return new int[] {-1, -1, -1};
        }
        int curr = (low + high) / 2;
        while (low <= high) {
            curr = (low + high) / 2;
            if (target < nums[curr]) {
                high = curr - 1;
            } else if (target > nums[curr]) {
                low = curr + 1;
            } else {
                System.out.println("result: " + curr + ", " + low + ", " + high);
                return new int[] {curr, low, high};
            }
        }
        return new int[] {-1, low, high};
    }
    public static void main(String[] args) {
        SearchForARange34 x = new SearchForARange34();
        int [] res = x.searchRange(new int[] {0,0,0,1,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11}, 1);
        for (int i : res) {
            System.out.println(i);
        }
    }

}
