package basicAlgorithm;

public class QuickSort {
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int lo = lowerIndex;
        int hi = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (lo < hi) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[lo] < pivot) {
                lo++;
            }
            while (array[hi] > pivot) {
                hi--;
            }
            if (lo <= hi) {
                exchangeNumbers(lo, hi);
                //move index to next position on both sides
                lo++;
                hi--;
            }
            System.out.println("lo " + lo + " pi " + pivot + " hi " + hi);
            for(int i : array){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
        // call quickSort() method recursively
        if (lowerIndex < hi)
            quickSort(lowerIndex, hi);
        if (lo < higherIndex)
            quickSort(lo, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String args[]){
        QuickSort sorter = new QuickSort();
        int[] input = {2,4,1,3,5,2,1};
        sorter.sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
// See more at: http://www.java2novice.com/java-sorting-algorithms/quick-sort/#sthash.hoQQIa0q.dpuf
}
