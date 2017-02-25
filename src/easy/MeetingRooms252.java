package easy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//  Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class MeetingRooms252 {
    /*public boolean canAttendMeetings(Interval[] intervals) {
        int [] arr = new int[intervals.length];
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        int a = 0;
        for(Interval i : intervals) {
            arr[a] = i.start;
            if(map.containsKey(i.start)) return false;
            map.put(i.start, i.end);
            a++;
        }
        Arrays.sort(arr);
        for (int x = 1; x <= intervals.length - 1; x++) {
            //next start earlier than this end, false
            if (arr[x] < map.get(arr[x - 1])) return false;
        }        
        return true;
    }*/
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, ((i, j) -> i.start - j.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}
