package easy;

public class ShortestWordDistance243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int dis = words.length;//distance
        boolean atWord1 = false, atWord2 = false;
        int p1 = -1, p2 = -1;//positions
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                p1 = i;
                if(atWord2) {
                    if(p2 != -1 && p1 - p2 < dis) {
                        dis = p1 - p2;
                    }
                }
                atWord2 = false;
                atWord1 = true;                
            } else if (words[i].equals(word2)) {
                p2 = i;
                if(atWord1) {
                    if(p1 != -1 && p2 - p1 < dis) {
                      dis = p2 - p1;
                    }                     
                }
                atWord2 = true;
                atWord1 = false;
            }
        }
        return dis;
    }
}
