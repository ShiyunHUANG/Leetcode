package easy;

public class PowerOfFour342 {
    /**Convert to 4 radix, slow*/
    public boolean isPowerOfFour(int num) {
        String str = Integer.toString(num,4);//convert to 4 radix number string
        System.out.println(str);
        return Integer.toString(num, 4).matches("10*");
    }
    /**Binary masks, fast*/
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //0x55555555 = 0b1010101010101010101010101010101
        //so that the single 1 bit always appears at the odd position 
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
