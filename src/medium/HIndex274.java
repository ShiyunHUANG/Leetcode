package medium;

import java.util.Arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 1; i <= citations.length; i++) {
            //compare current value with counts from current 
            if(citations[i - 1] >= citations.length - i + 1) {
                return citations.length - i + 1;
            }
        }
        return 0;
    }
}
