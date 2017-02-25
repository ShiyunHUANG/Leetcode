package easy;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //int[] res = nums1;//in this way they are still pointing to the same object. Must make a new copy!
        int[] res = new int[m];
        for(int i = 0; i < m; i++) {
            res[i] = nums1[i];
        }
        int i = 0, j = 0, k = 0;
        for (;k < m && j < n; i++) {
            if (res[k] < nums2[j]) nums1[i] = res[k++];
            else nums1[i] = nums2[j++];
        }
        System.out.println(nums1[i-1]);
        System.out.println("i " + i + " j "+j+" k "+k);
        while (j < n) {
            nums1[i++] = nums2[j++];
            System.out.println("A" + nums1[i-1]);
        }
        while (k < m) {
            nums1[i++] = res[k++];
            System.out.println("B " + nums1[i-1]);
        }
    }
    public static void main(String[] args) {
        MergeSortedArray88 x = new MergeSortedArray88();
        int[] arr = new int[]{2,0};
        x.merge(arr, 1, new int[]{1}, 1);
        for(int i : arr) {
            System.out.print(i+" ");
        }

    }

}
