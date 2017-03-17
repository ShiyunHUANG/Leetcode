package medium;
//almost die to find a one-pass solution
public class SortColors75 {
    //3.13.2017
    public void sortColors2(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int idx0 = 0, idx2 = nums.length - 1;
        for(int i = 0; i <= idx2 && idx0 < idx2;) { //<=!!
            if(nums[i] == 0) {
                if(i > idx0) {
                    nums[i] = nums[idx0];
                    nums[idx0] = 0;
                }
                idx0++;
                i++; //should move back when meet 0, only 1 is possible to be swaped with 0
            }
            else if(nums[i] == 2) {
                nums[i] = nums[idx2];
                nums[idx2] = 2;
                idx2--;
            }
            else { //move the pointer when meet 1
                i++;
            }
        }
    }
    
    
    public void sortColors(int[] nums) {
        int b1 = 0, b2 = nums.length - 1; //pointers and bounds
        for (int p = 0; p <= b2;) {
            if (nums[p] == 0) {
                swap(b1++, p++, nums);
                /*System.out.println("1st: ");
                for (int i : nums) {
                    System.out.print(i + ", ");
                }*/
                if (p > b1) continue;
            } else if (nums[p] == 2){
                swap(b2--, p, nums);
                /*System.out.println("2nd");
                 for (int i : nums) {
                    System.out.print(i + ", ");
                }*/
                if (p < b2) continue;
            } else { //nums[p] == 1;
                /*System.out.println("3rd");
                 for (int i : nums) {
                    System.out.print(i + ", ");
                }*/
                p++;
            }
        }
    }
    private void swap (int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
