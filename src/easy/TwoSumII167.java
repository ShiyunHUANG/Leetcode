package easy;
/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 */
public class TwoSumII167 {
	 public int[] twoSum(int[] numbers, int target) {
		 for(int i=0;i<numbers.length;i++){
			/*if(numbers[i]+numbers[numbers.length-1]<target){
				 return new int[]{-1,-1};
			}*/
			for(int j=i+1;j<numbers.length;j++){
				 if(numbers[i]+numbers[j]==target){
					 System.out.println(i+" "+j);
					 return new int[]{i+1,j+1};
				 }
			 }
		 }
		 return new int[]{-1,-1};
	 }
	public static void main(String[] args) {
		System.out.println(new TwoSumII167().twoSum(new int[] {5,25,75},100));
	}

}
