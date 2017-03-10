package AmazonOA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _HighFive {
    /**
     * @param results a list of <student_id, score>
     * @return the average of 5 highest scores of each id
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> map = 
            new HashMap<Integer, PriorityQueue<Integer>>(); //id - scores
        for(Record rec : results) {
            PriorityQueue<Integer> pq;
            if(map.containsKey(rec.id)) {
                pq = map.get(rec.id);
            } else {
                pq = new PriorityQueue<Integer>(5, (a, b) -> b - a);
                /*pq = new PriorityQueue<Integer>(5, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                });*/
            }
            pq.add(rec.score);
//            System.out.println(pq.size() + " ~ ");
            map.put(rec.id, pq);
        }
        //assume will have at least 5 records
        Map<Integer, Double> res = new HashMap<Integer, Double>();
        for(Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
            double avg = 0;
            PriorityQueue<Integer> pq = e.getValue();
            for(int i = 0; i < 5; i++) { //only poll() 5 times
                avg += pq.poll();
            }
            avg = avg / 5;
            res.put(e.getKey(), avg);
        }
        return res;
    }
    
    /* 
     * Other's correct answer 
     */
    public Map<Integer, Double> highFive2(Record[] results) {
        //思路是用一个PQ装所有record，poll出来放到map（id-score), 直到每个都有五条数据
        //每人至少有5份成绩，要取最高的5份的average
        if(results == null || results.length < 5) return new HashMap<Integer, Double>();

        /*PriorityQueue<Record> pq = new PriorityQueue<Record>(results.length, new Comparator<Record>() {
            @Override
            public int compare(Record R1, Record R2) {
                return R2.score - R1.score;
            }
        });*/
        PriorityQueue<Record> pq = new PriorityQueue<Record>(results.length, (a, b) -> b.score - a.score);
        for(Record re : results) {
            pq.offer(re);
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        while(!pq.isEmpty()) {
            Record re = pq.poll();
            if(!map.containsKey(re.id)) {
                map.put(re.id, new ArrayList<Integer>());
                map.get(re.id).add(re.score);
            }else{
                if(map.get(re.id).size() < 5) {
                    map.get(re.id).add(re.score);
                }
            }
        }

        Map<Integer, Double> res = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int scores = 0;
            for(int score : entry.getValue()) {
                scores += score;
            }
            Double s = scores / 5.0;
            res.put(entry.getKey(), s);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] input = {1,89,1,61,1,45,1,80,1,24,1,91,1,17,1,74,1,86,1,39};
        Record[] records = new Record[input.length / 2];
        for(int i = 0; i < input.length; i = i + 2) {
            int id = input[i];
            int score = input[i + 1];
            Record r = new Record(id, score);
            records[i / 2] = r;
        }
        _HighFive x = new _HighFive();
        Map<Integer, Double> res1 = x.highFive(records);
        System.out.println("res1");
        for(Map.Entry<Integer, Double> e : res1.entrySet()) {
            System.out.print("["+ e.getKey() + "," + e.getValue() + "] ");
        }
        System.out.println();
        Map<Integer, Double> res2 = x.highFive2(records);
        System.out.println("res2");
        for(Map.Entry<Integer, Double> e : res2.entrySet()) {
            System.out.print("["+ e.getKey() + "," + e.getValue() + "]");
        }
    }
}

// Definition for a Record
class Record {
    public int id, score;
    public Record(int id, int score){
        this.id = id;
        this.score = score;
    }
}

