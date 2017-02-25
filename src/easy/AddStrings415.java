package easy;

public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int len1 = n1.length;
        int len2 = n2.length;
        int carry = 0;
        for(int i = 1; i <= Math.min(len1, len2); i++) {
            int sum = n1[len1 - i] + n2[len2 - i] + carry - '0' - '0';
            carry = 0;
            if(sum > 9) {
                sb.insert(0, sum - 10);
                carry = 1;
            } else sb.insert(0, sum);
        }
        char[] remain = len1 > len2 ? n1 : n2;
        int len = Math.abs(len1 - len2);
        for(int i = 1; i <= len; i++) {
            int sum = remain[len - i] + carry - '0';
            carry = 0;
            if(sum > 9) {
                sb.insert(0, sum - 10);
                carry = 1;
            } else sb.insert(0, sum);
        }
        if (carry == 1) sb.insert(0, 1);
        return sb.toString();
        
    }
}
