package easy;

import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if(s[i] >= g[j]) {
                res++;
                j++;
            }
        }
        return res;
    }
}
