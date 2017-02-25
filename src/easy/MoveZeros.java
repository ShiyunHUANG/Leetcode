package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums, write a function to move all 0's 
 * to the end of it while maintaining the relative order 
 * of the non-zero elements. For example, given nums = [0, 1, 0, 3, 12],
 * after calling your function, nums should be [1, 3, 12, 0, 0]. 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        //!!!!!!!!!
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[j];//!!!!!!!!!notice the order of i and j
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }

        /*int left=0;
        int right=left+1;
        while(left<nums.length){
          //find the first non zero, store as left
            for(int j=0;j<nums.length;j++){
                if(nums[j]!=0){
                    left=j;
                    System.out.println("left:"+left);
                    right=left+1;
                    break;
                 }
            }
            //find the first zero to the right of the non zero, store as right
            for(int i=right;i<nums.length;i++){
                if(nums[i]==0){
                   left=i;
                   System.out.println("left:"+left);
                   break;
                }
            }
            
            //exchange them
            int temp=nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            //reset right and left
            right=right-1;
            left=left-1;
        }*/
        
        /**
         * Method 1:
         * Out of time limits
         */
        
        /*for(int i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==0&&nums[j]!=0){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    i++;
                }                
            }
        }*/
        
        /**
         * Method 2：
         * the following I misunderstood the question
         */
        
        /*int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[right]==0){
                System.out.println("1st if");
                right--;
                continue;
            }

            if(nums[left]==0&&right!=0){
                System.out.println("2nd if");
                nums[left]=nums[right];
                nums[right]=0;
                right--;
            }
            System.out.println("left++");
            left++;
        }
        System.out.println("right = "+right);
        for(int j=1;j<=right;j++){
            for(int k=j-1;k>=0;k--){
                if(nums[k]>nums[j]){
                    int temp=nums[k];
                    nums[k]=nums[j];
                    nums[j]=temp;
                }
            }
        }*/
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
    public static void main(String[] args) {
        new MoveZeros().moveZeroes(new int[] {0,2,3,0,0,7,0,0});
    }

}
