package easy;
/**
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory? 
 */
import java.util.HashMap;
import java.util.Map;
/**
 * Tags:
 * Hash Table, Bit manipulation
 */
public class SingleNumber136 {
	 public int singleNumber(int[] nums) {
		 Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		 for(int i=0;i<nums.length;i++){
			 if(!map.containsKey(nums[i])){
				 map.put(nums[i],1);				 
			 }
			 else map.put(nums[i], map.get(nums[i])+1);
		 }
		 for(int i=0;i<nums.length;i++){
			 if(map.get(nums[i]).equals(1)){
				 return nums[i];
			 }
		 }
		 return 0;
	 }
	public static void main(String[] args) {
		System.out.println(new SingleNumber136().singleNumber(new int[]{2,2,5,5,13,13,9}));
	}

}
