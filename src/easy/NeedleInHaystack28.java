package easy;

public class NeedleInHaystack28 {
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] goal = needle.toCharArray();
        if (goal.length == 0) {
            return 0;
        }
        int idxHay = 0;
        int idxGoal = 0;
OUTER:  while (idxHay < hay.length) {
            if (hay[idxHay] != goal[idxGoal]) {
                idxHay++;
                continue;
            }
            //here, the first char of goal and hay equals. Now check if all char equal.
            // System.out.println("***" + idxHay);
INNER:      while (idxGoal < goal.length - 1) {
                idxGoal++;
                idxHay++;
                // System.out.println(idxHay + " compare with " + idxGoal);
                try {
                    if (goal[idxGoal] != hay[idxHay]) {
                        idxHay = idxHay - idxGoal+1;
                        idxGoal = 0;
                        continue OUTER;
                    }                    
                } catch (Exception e) {// hay is out of bound.
                    return -1;
                }
            }
            return idxHay - idxGoal;
        }
        return -1;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
