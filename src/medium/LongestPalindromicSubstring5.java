package medium;
//medium
/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"*/
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int resX = 0, resY = 0; //if resX = 1 can't pass "abcda"
        int len = s.length();
        boolean dp[][] = new boolean [len][len];
        for(int x = 1; x < len; x++) {
            for(int y = x- 1; y >= 0 ; y--) {
                boolean isPalinInside = (x - y <= 2) || (dp[x - 1][y + 1]);
                if((s.charAt(x) == s.charAt(y)) && isPalinInside) {
                    dp[x][y] = true;
                    if(x - y >= resX - resY) { //if only > can't pass "cbbd"
                        resX = x;
                        resY = y;
                    }
                }
                
            }
        }
        return s.substring(resY, resX + 1);
    }
}
