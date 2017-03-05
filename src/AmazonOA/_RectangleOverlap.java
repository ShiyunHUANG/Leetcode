package AmazonOA;
/*
 * 
 * Example
Given l1 = [0, 8], r1 = [8, 0], l2 = [6, 6], r2 = [10, 0], return true
Given l1 = [0, 8], r1 = [8, 0], l2 = [9, 6], r2 = [10, 0], return `false

 * 给两个长方形的topLeft和bottomRight坐标, 判断这两个长方形是否重叠
 * Rectangle Overlap。这题和leetcode 算相交面积的区别：
 * 它帮你定义好两个类，一个叫Point，一个叫Rectangle，Rectangle包括左上右下两
 * 个Point, Point包括x, y的值， 这种细节并不影响程序，总之一句判断直接通过了全部20多个case.
 * */

public class _RectangleOverlap {
    /**
     * @param l1 top-left coordinate of first rectangle
     * @param r1 bottom-right coordinate of first rectangle
     * @param l2 top-left coordinate of second rectangle
     * @param r2 bottom-right coordinate of second rectangle
     * @return true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        int left1 = l1.x;
        int right1 = r1.x;
        int up1 = l1.y;
        int down1 = r1.y;
        int left2 = l2.x;
        int right2 = r2.x;
        int up2 = l2.y;
        int down2 = r2.y;
        if(right1 < left2 || right2 < left1 || up1 < down2 || up2 < down1) {
            return false; //not overlap
        }
        else return true;
    }
}
class Point {
    public int x, y;
    public Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }
}
