package easy;
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        long original = x;
        StringBuilder reverse =  new StringBuilder();
        if(x<0) reverse.append("-");
        while(x!=0){
            reverse.append(Math.abs(x%10));
            x = x/10;
        }
        long reverseInt = Long.valueOf(reverse.toString());
        if(reverseInt==original) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(2));
        System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
    }

}
