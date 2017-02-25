package easy;

public class StrobogrammaticNumber246 {
    /*from head and from tail, 6 must match 9 (vice versa), 1 and 8 must match itself*/
    public boolean isStrobogrammatic(String num) {
        char input[] = num.toCharArray();
        int p1 = 0, p2 = num.length() - 1;//pointers
        while(p1 <= p2) {
            if(input[p1] == '6') {
                if(input[p2] != '9') return false;
            } else if (input[p1] == '9') {
                if(input[p2] != '6') return false;
            } else if (input[p1] == '1' || input[p1] == '8'||input[p1] == '0') {
                if (input[p2] != input[p1]) return false;
            } else {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
