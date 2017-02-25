package medium;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len < 2) return 0;
        int p1 = 0, p2 = len - 1, area = 0, compare;
        while(p1 < p2) {
            int min = Math.min(height[p1], height[p2]);
            area = Math.max(area, min * (p2 - p1));
            if(height[p1] < height[p2]) {
                compare = height[p1];
                p1++;
                while(p1 < p2 && height[p1] <= compare) p1++;
            }
            else {
                compare = height[p2];
                p2--;
                while(p1 < p2 && height[p2] <= compare) p2--;
            }
        }
        return area;
    }
}
