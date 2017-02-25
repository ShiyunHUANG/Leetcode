package medium;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings48 {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return "";
        if(num1.equals("0") || num2.equals("0")) return "0";
        //find long and short str
        String longS, shortS;
        if(num1.length() >= num2.length()) {
            longS = num1;
            shortS = num2;
        } else {
            longS = num2;
            shortS = num1;
        }
        //multiply digit by digit
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        char[] shortArr = shortS.toCharArray();
        char[] longArr = longS.toCharArray();
        for(int x = shortArr.length - 1; x >= 0; x--) {
            int carry = 0;
            List<Integer> multi = new ArrayList<Integer>();
            for(int y = longArr.length - 1; y >= 0; y--) {
                int sum = (shortArr[x] - '0') * (longArr[y] - '0') + carry;
                carry = sum / 10;
                multi.add(0, sum % 10);
            }
            if(carry > 0) multi.add(0, carry);
            for(int i = 0; i < shortArr.length - 1 - x; i++) multi.add(0);
            list.add(multi);
        }
        // System.out.println(list);
        //add: same length part
        StringBuilder sb = new StringBuilder();//no need to ("")
        int carry = 0;
        int len = list.get(0).size();
        for(int i = 0; i < len; i++) {
            int sum = carry;
            for(List<Integer> li : list) sum = sum + li.get(li.size() - 1 - i);
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        // System.out.println(sb);//below is wrong
        if(list.size() == 1) {
            if(carry > 0) sb.insert(0, carry);
            return sb.toString();
        }
        //add: different length part
        for(int i = 0; i < list.get(list.size() - 1).size() - len; i++) {
            int sum = carry;
            int start = 1;
            for(int j = start; j < list.size(); j++) {
                List<Integer> li = list.get(j);
                int idx = li.size() - len - i - 1;
                if(idx < 0) {
                    start++;
                    continue;
                }
                sum = sum + li.get(idx);//some of them may have same length
            }
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        if(carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
