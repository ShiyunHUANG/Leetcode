package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight406 {
    public int[][] reconstructQueue(int[][] people) {
        //sort, get the highest, then insert lower one by one
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new LinkedList<int[]>();
        for(int i = 0; i < people.length; i++) {
            // System.out.println(people[i][0] + " " + people[i][1]);
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[list.size()][2]);
        //toArray(new Object[0]) is identical in function to toArray().
    }
}
