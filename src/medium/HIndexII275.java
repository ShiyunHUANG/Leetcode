package medium;

public class HIndexII275 {
    /**Linear search method*/
    public int hIndex(int[] citations) {
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i) { //pay attention to > or <
                return citations.length - i;//return the smaller one
            }
        }
        return 0;
    }
    /**Binary search method*/
    public int hIndex2(int[] citations) {
        int a = 0, b = citations.length - 1;
        int mid = 0;
        while(a <= b) {//not a < b - 1
            mid = a + (b - a) / 2;
            if(citations[mid] >= citations.length - mid) {
                b = mid - 1; //not b = mid
            }
            else {
                a = mid + 1;
            }
        }
        return citations.length - a;
    }
}
