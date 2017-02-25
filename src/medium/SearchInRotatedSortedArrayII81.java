package medium;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        int a = 0, b = nums.length - 1, mid;
        while(a <= b) {
            mid = (a + b) / 2;
            if(nums[mid] == target) return true;
            if(nums[b] <= nums[a]) { //rotated
                //find monotone interval
                boolean rightIsMonotone;//due to duplicate, hard to determine
                //1231111, 1111123, 1111111
                if(nums[b] < nums[mid]) rightIsMonotone = false;
                else if(nums[a] > nums[mid]) rightIsMonotone = true;
                else {
                    a++;
                    b--;
                    continue;
                }
                if(target > nums[mid]) {
                    if(!rightIsMonotone || (rightIsMonotone && target <= nums[b])) {
                        a = mid + 1;
                    } else {
                        b = mid - 1;
                    }
                } else {
                    if(rightIsMonotone || (!rightIsMonotone && target >= nums[a])) {
                        b = mid - 1;
                    } else {
                        a = mid + 1;
                    }
                }
            } else {
                return Arrays.binarySearch(nums, a, b + 1, target) >= 0;
            }
        }
        return false;
    }
}
