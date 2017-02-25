package easy;

public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {//!!!
            arr[i] = new StringBuilder("");
        }
        System.out.println(arr.length);
        int idx = 0;
        while(idx < s.length()) {
            for(int r = 0; r < numRows && idx < s.length(); r++, idx++) {
                System.out.println(r + " " + idx);
                arr[r].append(s.charAt(idx));
            }
            for(int r = numRows - 2; r > 0 && idx < s.length(); r--, idx++) {
                System.out.println(r + " " + idx);
                arr[r].append(s.charAt(idx));
            }
        }
        StringBuilder res = new StringBuilder("");
        for (StringBuilder sb : arr) {
            System.out.println(sb);
            res.append(sb);
        }
        return res.toString();
    }    
    public static void main(String[] args) {
        ZigZagConversion6 x = new ZigZagConversion6();
        System.out.println(x.convert("abcdef", 3));
    }

}
