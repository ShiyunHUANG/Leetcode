package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * find if the array contains any duplicates. Your function should return
 * true if any value appears at least twice in the array,
 * and it should return false if every element is distinct
 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        /*
         * HashSet got accepted too...
         */
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums){
            if(!set.add(i)){
                return true;
            }
            else set.add(i);
        }
        return false;
        /**
         * HashMap: out of time limit once but then accepted....
         */
       
        /*Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else return true;
        }
        return false;*/
        
    }
    public static void main(String[] args) {
        int[] x=new int[]{7,2,3,5,2};
        System.out.println(new ContainsDuplicate217().containsDuplicate(x));
    }

}
