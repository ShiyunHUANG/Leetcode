package medium;

public class isSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int ps = 0;
        for(int pt = 0; pt < t.length(); pt++) { 
            // System.out.println("pt " + pt + " < " + t.length());
            // System.out.println("ps " + ps + " " + (t.charAt(pt) == s.charAt(ps)));
            if(t.charAt(pt) == s.charAt(ps)) ps++;
            if(ps == s.length()) return true;
        }
        return false;
    }
    /**too complicated, no need to keep a separate list for pointers for s*/
    /*public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        List<Integer> ps = new ArrayList<Integer>(); //pointers for s
        for(int pt = 0; pt < t.length(); pt++) { //pointer for t'
        // System.out.println("pt " + pt + " < " + t.length());
            if(t.charAt(pt) == s.charAt(0)) {
                ps.add(0);
            }
            //check all ps
            for(int i = 0; i < ps.size(); i++) {
                // System.out.println("i " + i + " ps " + ps.get(i));
                if(t.charAt(pt) == s.charAt(ps.get(i))) ps.set(i, ps.get(i) + 1);
                if(ps.get(i) == s.length()) return true;//a pointer to s has reach the end
            }

        }
        return false;
    }*/
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
