package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum18 {
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    private List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 2) { //two pointers from left and right
            int left = start, right = len - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    //only need to skip dup when equal to target (when it will be added to res)
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;//becomes left + 1
                    right--;//becomes right - 1
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else {//remember to skip dup here too
            for(int i = start; i < len - (k - 1); i++) { //leave at least k - 1
                if(i > start && nums[i] == nums[i - 1]) continue;//skip dup
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);//not start + 1, is i + 1
                for(List<Integer> t : temp) {
                   t.add(0, nums[i]); //bigger one at index 0
                }                    
                res.addAll(temp);
                //equal skip 
/*                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }*/
            }
        }
        return res;
    }
    
    //TLE Method
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            // System.out.println("four" + path);
            threeSum(nums, i + 1, path, target - nums[i]);
            path.remove(path.size() - 1);
        }
        return res;
    }
    private void threeSum(int[] nums, int startIdx, List<Integer> path, int target) {
        for(int i = startIdx; i < nums.length; i++) {
            if(i > startIdx && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            // System.out.println("three" + path);
            twoSum(nums, i + 1, path, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
    //TLE
    private void twoSum(int[] nums, int startIdx, List<Integer> path, int target) {
        for(int i = startIdx; i < nums.length - 1; i++) {
            if(i > startIdx && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                if(nums[i] + nums[j] == target) {
                    path.add(nums[i]);
                    path.add(nums[j]);
                    // System.out.println("two" + path);
                    res.add(new ArrayList<Integer>(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
    //two sum no dup using hashmap is fine, with dup is kinda hard
    /*private void twoSum(int[] nums, int startIdx, List<Integer> path, int target) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = startIdx; i < nums.length; i++) {
            if(set.contains(target - nums[i])) {
                path.add(target - nums[i]);
                path.add(nums[i]);
                System.out.println("two" + path);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                path.remove(path.size() - 1);
            }
            set.add(nums[i]);
            if( i > startIdx && nums[i] == nums[i - 1]) continue;
        }
    }*/
}
