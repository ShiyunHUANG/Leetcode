package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
