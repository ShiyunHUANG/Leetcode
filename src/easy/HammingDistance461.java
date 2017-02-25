package easy;

public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }
    /**Naive way: Check if each bit equals 1 and return the sum*/
    int bitCount1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) { //Integer has 32 bits
            count = count + n & 1;
            n = n >>> 1;
        }
     
        return count;
    }
}
