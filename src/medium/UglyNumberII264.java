package medium;

import java.util.Arrays;

public class UglyNumberII264 {
    /**Right solution*/
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1; //special value
        int a = 0, b = 0, c = 0; //three pointers for 2, 3, 5
        int ct = 1; //count of ugly numbers
        while(ct < n) {
            int two = ugly[a] * 2,
            three = ugly[b] * 3,
            five = ugly[c] * 5;
            int min = Math.min(Math.min(two, three), five);
            ugly[ct] = min;
            if(two == min) a++;
            if(three == min) b++;
            if(five == min) c++;
            ct++;
        }
        return ugly[n - 1];
    }
    /**Got the wrong concept and messed up solution*/
    public int nthUglyNumber2(int n) {
        //all even numbers are ugly
        int bound = n * 2;
        //keep power of 3 and 5 within bound (define max use of 3 and 5 ALONE)
        int max3 = 0, max5 = 0, bound3 = bound, bound5 = bound;
        while(bound3 > 0) {
            bound3 /= 3;
            max3++;
        }
        while(bound5 > 0) {
            bound5 /= 5;
            max5++;
        }
        //use array to store product of 3 and 5
        int[] arr = new int[(max3 + 1) * (max5 + 1)];
        arr[0] = 1;
        int idx = 1;
        //first put all 3s in
        for(int i = 1; i <= max3; i++) {
            arr[idx] = 3 * arr[i - 1];
            idx++;
        }
        //then put 5s * 3s in
        for(int i = 0; i < max5; i++) {
            for(int j = (max3 + 1) * i; j <= (max3 + 1) * (i + 1) - 1; j++) {
                arr[idx] = 5 * arr[j];
                idx++;
            }
        }
        Arrays.sort(arr);
        //now insert all even numbers, find the nth ugly number
        int total = 1;
        for(int i = 1; i < arr.length; i++) {
            total = total + (arr[i] - arr[i - 1]) / 2; //add the even number in the middle
            total++; //add itself
            if(total == n) return arr[i];
            if(total > n) {
                return arr[i] - 1 - 2 * (total - n - 1);
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
