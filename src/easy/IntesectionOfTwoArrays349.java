package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection. 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]. 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

/**
 * Convert Integer to int.
 */
/*
 *Integer k=new Integer(10);
 *int kk=k.intValue();
 *System.out.println(k); 
 */

public class IntesectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map map=new HashMap();
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], 1);                
        }
        for(int j=0;j<nums2.length;j++){
            if(map.containsKey(nums2[j])&&!list.contains(nums2[j])){
                list.add(nums2[j]);
            }
        }
        System.out.println(list);
        int size=list.size();
        int res[]=new int[size];
        for(int k=0;k<size;k++){
            res[k]=list.get(k);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new IntesectionOfTwoArrays349().intersection(new int[]{3}, new int[]{3,3}));
    }

}
