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
    private int resX = 0, resY = 0; //if resY = 1 can't pass "abcda"
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int len = s.length();
        //dp 2D matrix, x is substring start index, y is substring end idx
        boolean[][] dp = new boolean[len][len + 1]; //default to be false
        for(int y = 1; y < len; y++) { //substring end index
            for(int x = y - 1; x >= 0; x--) { //substring start index
                boolean isPalinInside = (y - x <= 2) || dp[x + 1][y - 1]; //2 not 1
                if(s.charAt(x) == s.charAt(y) && isPalinInside) {
                    dp[x][y] = true;
                    //check if it is the longest 
                    if(y - x > resY - resX) {
                        resX = x;
                        resY = y;
                    }
                }
            }
        }
        return s.substring(resX, resY + 1);
    }
}
