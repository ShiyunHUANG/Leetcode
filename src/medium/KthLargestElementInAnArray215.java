package medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i, j) -> i - j);//sort small to big
        for (int n : nums) {
            if (pq.size() < k || n > pq.peek()) {
                pq.add(n);
            }
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
    public static void main(String[] args) {

    }

}
