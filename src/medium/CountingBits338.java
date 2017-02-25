package medium;

public class CountingBits338 {
    public int[] countBits(int num) {
        int [] arr = new int[num + 1];
        arr[0] = 0;
        for (int j = 0; Math.pow(2,j) <= num ; j++) {
            // System.out.println("j: " + j + " pow: " + Math.pow(2,j));
            arr[(int)Math.pow(2,j)] = 1;
            for (int i = 1; (int) Math.pow(2, j) + i <= num; i++) { // ending condition is not i < Math.min(num, Math.pow(2,j))
                // System.out.println("i: " + i + " j " + j + " min " + Math.min(num, Math.pow(2,j)) + " size: " + arr.length);
                arr[(int) Math.pow(2, j) + i] = 1 + arr[i]; //since all Math.pow(2, j) == 1
            }
        }
        return arr;
    }
    public static void main(String[] args) {

    }

}
