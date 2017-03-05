package AmazonOA;

import java.util.Comparator;
import java.util.PriorityQueue;

//Top K always use min/max heap, PriorityQueue
//Notice, PQ poll() the head, that is the best match one. 
//PQ will remove the worst match one when full, no need to poll()

/*
 * Given some points and a point origin in two dimensional space,
 * find k points out of the some points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance,
 * sorted by x-axis, otherwise sorted by y-axis.
 * [Note] Distance is just sqrt(delta x^2 + delta y^2)
 * Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]
 */
public class _KNearestPoints {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        final Point ori = origin;
        /*PriorityQueue<Point> pq = new PriorityQueue<Point>(k, 
        (p1, p2) -> (Math.pow(p1.x - origin.x, 2) + Math.pow(p1.y - origin.y, 2)
        - Math.pow(p2.x - origin.x, 2) + Math.pow(p2.y - origin.y, 2)) == 0 ? p1.x - p2.x : 
            (Math.pow(p1.x - origin.x, 2) + Math.pow(p1.y - origin.y, 2)
            - Math.pow(p2.x - origin.x, 2) + Math.pow(p2.y - origin.y, 2)) > 0 ? 1 : -1);*/
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                double delta =  (Math.pow(a.x - ori.x, 2) + Math.pow(a.y - ori.y, 2)
                - Math.pow(b.x - ori.x, 2) - Math.pow(b.y - ori.y, 2));
                if(delta == 0) return a.x - b.x;
                else if (delta > 0) return 1;
                else return -1;
            }
        });
        for(Point p : points) {
            pq.add(p);
//            if(pq.size() > k) pq.poll(); //!!!No need to poll(), poll() is from head
        }
        Point[] res = new Point[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll(); 
        }
        
        return res;
    }
    public static void main(String[] args) {
        Point[] p = new Point[5];
        p[0] = new Point(4,6);
        p[1] = new Point(4,7);
        p[2] = new Point(4,4);
        p[3] = new Point(2,5);
        p[4] = new Point(1,1);
        _KNearestPoints x = new _KNearestPoints();
        Point[] res = x.kClosest(p, new Point(0,0), 3);
        System.out.println("result is: ");
        for(Point pt : res) {
            System.out.print("["+ pt.x + "," + pt.y +  "] ");
        }
        
        
        
    } 
}
