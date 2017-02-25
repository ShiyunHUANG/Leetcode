package medium;

import java.util.Arrays;

public class Heaters475 {
    /**
     * Binary search solution
     * @param houses
     * @param heaters
     * @return minimum radius
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;//left heater
                //return max_val because later will get min of dist1 and dist2
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;//right heater
                
                result = Math.max(result, Math.min(dist1, dist2));
            }
        }
        
        return result;
    }
}
