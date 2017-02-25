package easy;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        if(s.trim().equals("")) {
            return true;
        }
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] < '0' || arr[left] > '9' && arr[left] < 'A' || arr[left] > 'Z' && arr[left] < 'a' || arr[left] > 'z') {
                left ++;
                continue;
            }
            if (arr[right] < '0' || arr[right] > '9' && arr[right] < 'A' || arr[right] > 'Z' && arr[right] < 'a' || arr[right] > 'z') {
                right --;
                continue;
            }
            if (Character.toUpperCase(arr[left]) != Character.toUpperCase(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
