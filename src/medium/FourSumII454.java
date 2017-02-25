package medium;

import java.util.Arrays;
import java.util.HashMap;

public class FourSumII454 {
    //correct answer
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : A) {
            for (int b : B) {
                int temp = a + b;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } 

        }
       for(int c : C) {
           for(int d : D) {
               int temp = c + d;
               if(map.containsKey(-temp)) res = res + map.get(-temp);
           }
       }
        return res;
    }
    //wrong answer
    public int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : A) {
            for (int b : B) {
                int temp = a + b;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } 

        }
        Arrays.sort(C);
        Arrays.sort(D);
        for(int k : map.keySet()) {
            int val = map.get(k);
            res = res + twoSum(C, D, -k) * val;
        }
        return res;
    }
    private int twoSum(int[] C, int[] D, int target) {
        int len = C.length;
        int res = 0;
        int c = 0, d = len - 1;
        while (c < len && d >= 0) {
            int sum = C[c] + D[d];
            if( sum == target) {
                res++;
                c++;
                d--;
            }
            else if (sum < target) c++;
            else d--;
        }
        return res;
    }
    //TLE
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : A) {
            for (int b : B) {
                int temp = a + b;
                for(int c : C) {
                    temp = temp + c;
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    temp = temp - c;
                }
            } 
        }
        for(int d : D) {
            if(map.containsKey(-d)) {
                res = res + map.get(-d);
            }
        }
        return res;
    }

}
