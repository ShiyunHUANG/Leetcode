package medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        if(nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + 1 == nums[i]) { //!!nums[i] - 1 == nums[i - 1] may overflow!!!
                if(i < nums.length - 1) continue;
                else i++;
            }
            String str = String.valueOf(nums[start]);
            if(i - 1 > start) str = str + "->" + String.valueOf(nums[i - 1]);
            res.add(str);
            if(i == nums.length - 1 && nums[i - 1] + 1 != nums[i]) res.add(String.valueOf(nums[i]));
            start = i;
        }
        return res;
    }
}
