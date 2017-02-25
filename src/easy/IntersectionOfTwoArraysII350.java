package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given two arrays, write a function to compute their intersection. 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2]. 
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
public class IntersectionOfTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> m1=new HashMap<Integer,Integer>();
        for(int i:nums1){
            if(!m1.containsKey(i)){
                m1.put(i, 1);
            }
            else m1.put(i, m1.get(i)+1);
        }
        List<Integer> res=new ArrayList<Integer>();
        for(int i:nums2){
            if(m1.containsKey(i)&&m1.get(i)>0){//not >=0,because you put 1 when first occurance
                res.add(i);
                m1.put(i, m1.get(i)-1);
            }
        }
        System.out.println(res);
        int arr[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
        
    }
    public static void main(String[] args) {
        int x1[]=new int[]{1,1};
        int x2[]=new int[]{1,1,1};
        int intersect[]=new IntersectionOfTwoArraysII350().intersect(x1, x2);
        for(int i=0;i<intersect.length;i++){
            System.out.print(intersect[i]+ " ");
        }
    }

}
