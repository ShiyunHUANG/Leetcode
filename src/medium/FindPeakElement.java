package medium;

import java.util.LinkedList;
import java.util.List;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        //find an interval whose left trend is increase and right trend is decrese
        if (nums.length <= 2) {
            if (nums[0] > nums[nums.length - 1]) return 0;
            return nums.length - 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;//increasing, right is bigger
            } else {
                right = mid;// decresing, left is bigger
            }
        }
            //right = left + 1, return index
            if (nums[left] > nums[right]) return left;
            return right;
        }
        /*List<Integer> idx = new LinkedList<Integer>();
        idx.add(0);
        idx.add(nums.length - 1);
        boolean b = hasPeak(0, nums.length - 1, nums);
        int i = 0;
        //first find a range that contains peak element.
        while (!b) {
            List<Integer> idxCopy = new LinkedList<Integer>(idx);
            for (i = 0; i < idxCopy.size(); i++) {
                b = hasPeak(nums[i], nums[i + 1], nums);
                if (b) break;
                idx.add(i + 1, (nums[i] + nums[i + 1]) / 2);
            }            
        }
        //then search this range until close up to one element.
        int low = nums[i];
        int high = nums[i + 1];*/



    /*private boolean hasPeak(int idx1, int idx2, int[] nums) {
        int mid = (idx1 + idx2) / 2;
        int res = (nums[idx1] - nums[mid]) * (nums[idx2] - nums[mid]);
        return res < 0 ;
    }*/
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
