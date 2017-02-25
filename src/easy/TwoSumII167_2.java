package easy;
public class TwoSumII167_2 {
	public int[] twoSum(int[] numbers, int target) {
	       int left=0;
	       int right=numbers.length-1;
	       while(left<=right){
	    	   int res=numbers[left]+numbers[right];
	    	   System.out.println("in while "+"res: "+res+" target:"+target+" right:"+right+" left:"+left);
	    	   if(res==target){
	            	System.out.println(left+" "+right);
	            	return new int[]{left+1,right+1}; 
	    	   }
	    	   if(res<target)left++;
	            if(res>target)right--;
	                      
	            
	       }
	       System.out.println("no match ");
	       return new int[]{-1,-1};
	   }
	public static void main(String[] args) {
		System.out.println(new TwoSumII167_2().twoSum(new int[] {1,2,3},3));
	}

}
