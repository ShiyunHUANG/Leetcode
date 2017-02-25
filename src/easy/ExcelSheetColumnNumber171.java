package easy;
/**
 * Given a column title as appear in an Excel sheet,
 * return its corresponding column number.
 * For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */

public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String s) {
        if(s==null)return 0;
        char arr[]=s.toCharArray();
        int res=(arr[s.length()-1]-'A'+1);
        for(int i=0;i<arr.length-1;i++){
            res=(int) (res+(arr[i]-'A'+1)*Math.pow(26, arr.length-i-1));
        }
        return res;
    }
    
    /*
     * A　better method by others.
     * 
     * public int titleToNumber(String s) {
            int result = 0;
            for(int i = 0 ; i < s.length(); i++) {
                result = result * 26 + (s.charAt(i) - 'A' + 1);
            }
            return result;
       }
     */
    
    public static void main(String[] args) {
        int x=new ExcelSheetColumnNumber171().titleToNumber("AC");
        System.out.println(x);
    }

}
