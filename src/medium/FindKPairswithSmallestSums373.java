package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<int[]>();
        //both nums1 and nums2 have at least 1 element.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        List<int[]> res = new ArrayList<int[]>();
        int bound = Math.min(k, nums2.length);
        for (int i = 0; i < bound; i++) {
            pq.add(new Pair(0, i, nums1, nums2));
        }
        //bound is min of k and total number of pairs
        for (int count = 0; count < Math.min(k, nums1.length * nums2.length); count++) {
            Pair temp = pq.poll();
            // System.out.println(temp.i + " " + temp.j);
            res.add(temp.ij);
            if (temp.i < nums1.length - 1) {
                pq.add(new Pair(temp.i + 1, temp.j, nums1, nums2));
            }
        }
        return res;
    }
}
class Pair implements Comparable<Pair> {
    int i, j, sum;//i is row, j is col.
    int[] ij;
    public Pair(int i, int j, int [] nums1, int[] nums2) {
        this.i = i;
        this.j = j;
        ij = new int[]{nums1[i], nums2[j]};
        sum = nums1[i] + nums2[j];
    }
    @Override
    public int compareTo(Pair next) {
        return this.sum - next.sum;
    }
}
