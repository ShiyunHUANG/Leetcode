package medium;

public class TwoSumIIInputArrayIsSorted167 {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
          int right=numbers.length-1;
          while(left<=right){
              int res=numbers[left]+numbers[right];
              if(res==target){
                   return new int[]{left+1,right+1}; 
              }
              if(res<target)left++;
              if(res>target)right--;
          }
          return new int[]{-1,-1};
   }
}
