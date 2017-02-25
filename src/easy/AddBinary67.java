package easy;

public class AddBinary67 {
    //second time 1/29/2017
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        int p1 = a.length() - 1, p2 = b.length() - 1, carry = 0;
        while(p1 >= 0 && p2 >= 0) {
            char ch1 = a.charAt(p1);
            char ch2 = b.charAt(p2);
            int sum = ch1 - '0' + ch2 - '0' + carry;
            if(sum >= 2) {
                carry = sum / 2;
                sb.insert(0, sum % 2);
            } else {
                sb.insert(0, sum);
                carry = 0;
            }
            p1--;
            p2--;
        }
        if(p1 >= 0 || p2 >= 0) {
            int p;
            String s;
            if(p1 >= 0) {
                p = p1;
                s = a;
            } else {
                p = p2;
                s = b;
            }
            while(p >= 0) {
                int sum = s.charAt(p) - '0' + carry;
                if(sum >= 2) {
                    carry = sum / 2;
                    sb.insert(0, sum % 2);
                } else {
                    sb.insert(0, sum);
                    carry = 0;
                }
                p--;
            }
        } 
        while(carry > 0) {
            sb.insert(0, 1);
            carry--;
        }
        return sb.toString();
    }
    
    //first time 10/18/2016
    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        StringBuilder res = new StringBuilder("");
        int num1;
        int num2;
        int sum;
        int carry = 0;
        while (Math.max(lengthA, lengthB) > 0) {
            if (lengthA > 0) {
                num1 = a.charAt(lengthA - 1) - '0';
                lengthA--;
            } else {
                num1 = 0;
            }
            if (lengthB > 0) {
                num2 = b.charAt(lengthB - 1) - '0';   
                lengthB--;
            } else {
                num2 = 0;
            }
            sum = num1 + num2 + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
    /*public String addBinary(String a, String b) {
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        StringBuilder res = new StringBuilder("");
        int carry = 0;
        for (int p1 = num1.length - 1, p2 = num2.length - 1; p1 >= 0 && p2 >= 0; p1--, p2--) {
           if ((num1[p1] & num2[p2]) - '0' == 0) {
               if (carry == 0) {
                   res.append((num1[p1] - '0')| (num2[p2] - '0'));   
               } else {
                   if ((num1[p1] | num2[p2] - '0') == 1) {
                       res.append(0);
                   } else {
                       res.append(1);
                   }
                   carry = 1;
               }
           } else {
               if (carry == 0) {
                   res.append(0);
               } else {
                   res.append(1);
               }
               carry = 1; 
           }
        }
        if(carry == 1) {
            res.append(1);
        }
        res.reverse();
        return res.toString();
        
    }*/
    public static void main(String[] args) {
        AddBinary67 x = new AddBinary67();
        x.addBinary("101", "010");
    }

}
