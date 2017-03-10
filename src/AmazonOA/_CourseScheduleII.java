package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//need to consider situation when it is impossible to finish all courses!
public class _CourseScheduleII {
    //beat 50%
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //a list to map pre -> course
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        //an array to map course -> number of pres
        int[] arrayMap = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }
        for(int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            if(graph.get(pre).contains(course)) continue; //just to remove dupclicate input
            graph.get(pre).add(course);
            arrayMap[course]++;
        }
        //find all courses that don't need prerequistes and store in a list
        Queue<Integer> courseToVisit = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(arrayMap[i] == 0) courseToVisit.add(i);
        }
        //a result list to store the path
        List<Integer> res = new ArrayList<Integer>();
        //bfs
        while(!courseToVisit.isEmpty()) {
            int curCourse = courseToVisit.poll();
            res.add(curCourse);
            //find the courses that need this course as prerequisite
            Set<Integer> courseSet = graph.get(curCourse);
            for(int cs : courseSet) {
                arrayMap[cs] = arrayMap[cs] - 1;
                if(arrayMap[cs] == 0) courseToVisit.add(cs);
            }
        }
        //check the result
        int[] resArr= new int[numCourses];
        if(res.size() < numCourses) return new int[]{};
        else {
            for(int i = 0; i < numCourses; i++) {
                resArr[i] = res.get(i);
            }
        }
        return resArr;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
