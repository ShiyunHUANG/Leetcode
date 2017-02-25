package easy;

public class NthDigit400 {
    public int findNthDigit(int n) {
        int multi = 1;
        long nine = 9; //this is long!!!!!
        while(n - nine * multi > 0) {
            n = (int) (n - nine * multi);
            nine *= 10;
            multi++;
        }
        long start = (long) Math.pow(10, multi - 1);
        long idx = (n - 1) / multi, remain = (n - 1) % multi;
        long num = start + idx;
        int res = (int) num % 10;
        System.out.println("start " + start + " multi " + multi + " num " + num + " res " + res);
        for(int i = 1; i < multi - remain; i++) {
            num = num / 10;
            res = (int) num % 10;
        }
        return res;
    }
}
