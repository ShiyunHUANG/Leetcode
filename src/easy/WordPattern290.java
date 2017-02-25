package easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        String strArr [] = str.split(" ");
        char[] patArr = pattern.toCharArray();
        if (strArr.length != patArr.length) {
            return false;
        }
        //same length.
        Map map = new HashMap();
        for (Integer i = 0; i < strArr.length; i++) {//!!Here if use int will make mistake!
            if (map.put(strArr[i], i) != map.put(patArr[i], i)) {
                System.out.println("***** " + i + " str " + strArr[i] + " pat " + patArr[i]);
                return false;
            }
            System.out.println("idx: " + i + " pat " + patArr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        Integer x = 128;
        Integer y = 128;
        Integer a = 127;
        Integer b = 127;
        System.out.println(x == y);//false
        System.out.println(a == b);//true
    }

}
