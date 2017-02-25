package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceScreenFitting418 {
    int r = 1, c = 0, res = 0, rows, cols;
    Map<Integer, int[]> map = new HashMap<Integer, int[]>();//key is word idx at col 0, value is row and res
    public int wordsTyping(String[] sentence, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        if(rows <= 0 || cols <= 0) return 0;
        List<Integer> list = new ArrayList<Integer>();
        int len = 20001;//longer than cols
        int i = 0;
        for( ; i < sentence.length; i++) {
             System.out.println("first: i " + i);
            len = sentence[i].length();
            if(!validate(len, i)) return res;//a word can't fit
            list.add(len);//add all number
        }
        res++;
        while(r <= rows) {
            System.out.println("next " + r);
            for(i = 0; i < list.size(); i++) {
                if(!validate(list.get(i), i)) return res;
            }
            res++;
        }
        return res;
    }
    private boolean validate(int len, int idx) {//rows and cols start from 0
         System.out.println("validate: r " + r + " c: " + c + " len " + len);
        if(len > cols || r > rows) return false;
        else if(c == 0) {
            System.out.println(map.containsKey(idx));
            if(map.containsKey(idx)) {//repeat
                int repeat = (rows - r) / (r - map.get(idx)[0]);
                System.out.println("repeat: " + repeat + " cur res: " + res + " old res: " + map.get(idx)[1]);
                System.out.println(" cur r: " + r + " old r: " + map.get(idx)[0]);
                res = res + (res - map.get(idx)[1])* repeat;//?
//                r = rows - (rows - r) % (r - map.get(idx)[1]);
                r = r + repeat * (r - map.get(idx)[0]);
                map.clear();
            } else map.put(idx, new int[]{r, res});
            c = len;
            return true;
        }
        else {// c > 0, need a space
            if(c + len + 1 > cols)  { //len - 1 + 1
                r = r + 1;
                c = 0;
                return validate(len, idx);
            }
            else {
                c = c + len + 1;//fit
                return true;
            }
        }
    }
    public static void main(String[] args) {
        SentenceScreenFitting418 x = new SentenceScreenFitting418();
        String[] sen = {"a", "world", "cat"};
        System.out.println("res " + x.wordsTyping(sen, 20000, 20000));
        //        x.test(0);
    }
  //????
    int global = 0;
    public int test(int num) {
        num = testAdd(num);
        global++;
        testAdd(global);
        System.out.println("local " + num + " global " + global);
        return num;
    }
    private int testAdd(int num) {//void or not, doesn't change
        num = num + 1;
        this.global = 10;
        System.out.println("private " + num);
        return num + 1;
    }
    /*public int wordsTyping(String[] sentence, int rows, int cols) {
    if(rows <= 0 || cols <= 0) return 0;
    int r = 0, c = 0, res = 0;
    List<Integer> list = new ArrayList<Integer>();
    int len = 20001;//longer than cols
    int i = 0;
    for( ; i < sentence.length; i++) {
        System.out.println("~~~" + i);
        len = sentence[i].length();
        boolean b = validate(len, r, c, rows - 1, cols - 1);
        if(!b) return res;//a word can't fit
        list.add(len);//add all number
    }
    res++;
    while(r <= rows - 1) {
        System.out.println("***" + r);
        for(i = 0; i < list.size(); i++) {
            boolean b = validate(len, r, c, rows - 1, cols - 1);
            System.out.println("r " + r + " c " + c);
            if(!b) return res;
        }
        res++;
    }
    return res;
}
private boolean validate(int len, int r, int c, int rows, int cols) {//rows and cols start from 0
//    System.out.println("validate: r " + r + " c: " + c + " len " + len + " cols " + cols);
    if(len - 1 > cols) return false;
    if(r > rows) return false;//in recurrsion
    if(c == 0) {
        c = len - 1;
        System.out.println(c);
        return true;
    }
    else {// c > 0, need a space
        if(c + len > cols)  { //len - 1 + 1
            return validate(len, r++, 0, rows, cols);
        }
        else {
            c = c + len;//fit
            return true;
        }
    }
}*/
}
