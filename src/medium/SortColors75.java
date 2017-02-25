package medium;
//almost die to find a one-pass solution
public class SortColors75 {
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
