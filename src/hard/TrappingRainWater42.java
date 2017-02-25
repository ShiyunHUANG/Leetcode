package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrappingRainWater42 {
    /**Beat 30% 2 pointers method*/
    public int trap(int[] H) {
        int len = H.length;
        if(len <= 2) return 0;
        int i = 0, j = len - 1;//two pointers
        int maxLeft = 0, maxRight = 0, res = 0;
        while(i < j) {
            if(H[i] < H[j]) {
                maxLeft = Math.max(maxLeft, H[i]);
                res += maxLeft - H[i];
                i++; //lower is the bound, move lower
            } else {
                maxRight = Math.max(maxRight, H[j]);
                res += maxRight - H[j];
                j--;
            }
        }
        return res;
    }
    /**Stack base method, beat 5%*/
    public int trap2(int[] H) {
        int len = H.length, res = 0;
        if(len <= 2) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i < len) { //while loop not for loop
            if(stack.isEmpty() || H[i] <= H[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int bottom = stack.pop();
                if(stack.isEmpty()) continue;
                int left = stack.peek();
                int right = i;
                res = res + (Math.min(H[left], H[right]) - H[bottom]) * (right - left - 1);
            }
        }
        return res;
    }
    /**My wrong method*/
    public int trap3(int[] height) {
        int len = height.length;
        if(len <= 2) return 0;
        int i = 0;
        List<Integer> peaks = new ArrayList<Integer>();
        while(i < len - 1 && height[i] <= height[i + 1]) i++; //going up
        peaks.add(i);
        int start = i, end, res = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        while(i < len - 1) {
            while(i < len - 1 && height[i + 1] <= height[i]) {
                i++;
                stack.push(i);
            } //reach the bottom
            while(i < len - 1 && height[i + 1] >= height[i]) {
                i++;
                stack.push(i);
            }
            /*if(i == len - 1) end = i;
            else { //normal case
                end = i;
                stack.pop();
            }*/
            if(stack.isEmpty()) break;
            end = i;
            stack.pop();
            System.out.println("start " + start + " end " + end + " min " + Math.min(height[start], height[end]));
            int min = Math.min(height[start], height[end]);
            res = res + (end - start - 1) * (min);
            while(!stack.isEmpty()) {
                System.out.println("pop: " + stack.peek());
                int minus = Math.min(height[stack.pop()], min);
                res = res - minus;
            }
            start = i = end;
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
