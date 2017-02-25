package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else map.put(nums[i], map.get(nums[i])+1);
        }
        for(int j=0;;j++){
            if(map.get(nums[j])>nums.length/2){
                 return nums[j];
            }
        }
    }
    public static void main(String[] args) {
        int x=new MajorityElement169().majorityElement(new int[]{6,5,5,5,5});
        System.out.println(x);
    }

}
