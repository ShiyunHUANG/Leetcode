package easy;

import java.util.ArrayList;
import java.util.Stack;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        for (int d : digits) {
            if (d != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] res = new int [digits.length + 1]; 
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return  res;
        }
        int i = digits.length - 1;
        while (digits[i] == 9 && i > 0) {
           digits[i] = 0;
           i--;
        }
        digits[i] = digits[i] + 1;
           return digits;
       }
    public static void main(String[] args) {
        PlusOne66 x = new PlusOne66();
        x.plusOne(new int[] {1,2,3,4,5});
    }

}
