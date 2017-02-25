package medium;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() < 3) return s;
        String[] arr = s.trim().split(" ");
        for(String a : arr) {
            System.out.print(a + ",");
        }
        System.out.println();
        int len = arr.length;
        int p1 = 0, p2 = len - 1, offset = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 <= p2) {
            while(arr[p1].length() == 0) p1++;
            while(arr[p2].length() == 0) p2--;
            if(p1 >= p2) {
                if(p1 == p2) sb.insert(offset, arr[p1]); 
                else sb.deleteCharAt(offset);
                break;
            }
            sb.insert(offset, arr[p2] + " ");
            offset += arr[p2].length() + 1;
            sb.insert(offset, p1 < p2 - 1 ? " " + arr[p1] : arr[p1]);
            p1++;
            p2--;
        }
        System.out.println(sb.length());
        return sb.toString();
    }
    public static void main(String[] args) {
        ReverseWordsInAString151 x = new ReverseWordsInAString151();
        System.out.println(x.reverseWords(" a b           c d "));
        
    }

}
