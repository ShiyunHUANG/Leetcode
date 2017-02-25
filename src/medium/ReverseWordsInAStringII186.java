package medium;

public class ReverseWordsInAStringII186 {
  //XOR swap
    public void reverseWords(char[] s) {
        for(char c : s) {
            System.out.print(c);
        }
        System.out.println();
        //first
        int p1 = 0, p2 = s.length - 1;
        while(p1 < p2) {
            s[p1] = (char) (s[p1] ^ s[p2]);
            s[p2] = (char) (s[p2] ^ s[p1]);
            s[p1] = (char) (s[p2] ^ s[p1]);
            p1++;
            p2--;
        }
        //next
        int st = 0, en = 0; //start and end
        while(en < s.length) {
            while(en < s.length && s[en] != ' ') {
                en++;
            }
            en--;
            while(st < en) {
                s[st] = (char) (s[st] ^ s[en]);
                s[en] = (char) (s[en] ^ s[st]);
                s[st] = (char) (s[st] ^ s[en]);
                st++;
                en--;
            }
            while(st < s.length && s[st] != ' ') {
                st++;
            }
            st++;
            en = st + 1;
        }
    }
    public static void main(String[] args) {
        ReverseWordsInAStringII186 x = new ReverseWordsInAStringII186();
        char[] ch = new char[]{'a',' ', '2', 'b', ' ', '3', '4', 'c'};
        x.reverseWords(ch);
        for(char c : ch) {
            System.out.print(c);
        }
    }

}
