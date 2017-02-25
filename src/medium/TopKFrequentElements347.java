package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k > nums.length) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((i, j) -> j.getValue() - i.getValue());// map.values();
        /** This is the same as below*/
        /*Comparator c = new myComparator();
        class myComparator implements Comparator<Entry<Integer, Integer>> {
            @Override
            public int compare(Entry<Integer, Integer> i, Entry<Integer, Integer> j) {
                return j.getValue() - i.getValue();
            }
        }*/
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            pq.add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int count = 0; count < k; count++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
