package easy;

public class ReverseVowelsofaString345 {
    private boolean isVowel(char input) {
        String vowels = "aeiouAEIOU";
        if (vowels.contains(String.valueOf(input))) {
            return true;
        }
        return false;
        /*char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char ch : vowels) {
            if (input == ch) {
                return true;
            }
        }
        return false;*/
    }
    public String reverseVowels(String s) {
       char[] arr = s.toCharArray();
       int left = 0;
       int right = arr.length - 1;
       while (left <= right) {
           while (left < arr.length && !isVowel(arr[left])) {
                left++;   
           }
           while (right >= 0 && !isVowel(arr[right])) {
               right--;
           }
           //swap
           if (left < right) {
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp; 
           }
           left++;
           right--;
       }
       /*String res = new String("");
       for (char ch : arr) {
           res = res + ch;
       }
       return res;*/
       return new String(arr);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
