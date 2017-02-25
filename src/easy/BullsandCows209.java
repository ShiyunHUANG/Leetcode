package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BullsandCows209 {
    public String getHint(String secret, String guess) {
        Integer numA = 0;
        Integer numB = 0;
        char arrSecret [] = secret.toCharArray();
        char arrGuess [] = guess.toCharArray();
        Map<Character, ArrayList<Integer>> mapSecret = new HashMap<Character, ArrayList<Integer>>();
        Map<Character, Integer> mapKeySize = new HashMap<Character, Integer>();
        //build a map with all the value in secret
        for (int i = 0; i < arrSecret.length; i++) {
            if (!mapSecret.containsKey(arrSecret[i])) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                mapSecret.put(arrSecret[i], list);
            } else {
                ArrayList<Integer> list = mapSecret.get(arrSecret[i]);
                list.add(i);
                mapSecret.put(arrSecret[i], list);
            }
            mapKeySize.put(arrSecret[i], mapSecret.get(arrSecret[i]).size());//build mapKeySize
        }
        Map<Character, Integer> mapGuess = new HashMap<Character, Integer>();
        for (int j = 0; j < arrGuess.length; j++) {
            if (!mapSecret.containsKey(arrGuess[j])) continue;
            boolean exactMatch = false;
            //guess has key, check if exact match
            for (int idx : mapSecret.get(arrGuess[j])) {
                System.out.println(mapSecret.get(arrGuess[j]) + " idx " + idx);
                //if exact match.
                if (j == idx) {
                    numA++;
                    //mapGuess.put(arrGuess[j], mapGuess.get(arrGuess[j])-1);
                    mapKeySize.put(arrGuess[j], mapKeySize.get(arrGuess[j])-1);
                    exactMatch = true;
                    break;
                }
            }
          //if not exact match
            if (exactMatch) continue;
            if(!mapGuess.containsKey(arrGuess[j])){
                mapGuess.put(arrGuess[j], 1);
                System.out.println("add new");
            } else {
                mapGuess.put(arrGuess[j], mapGuess.get(arrGuess[j])+1);
                System.out.println("add again");
            }
        }
        for (char ch : mapGuess.keySet()) {
            if(mapKeySize.containsKey(ch)) {
                System.out.println(mapGuess.get(ch) + " " +  mapKeySize.get(ch));
                numB = numB + Math.min(mapGuess.get(ch), mapKeySize.get(ch));
            }
        }
        String res = numA.toString() + "A" + numB.toString() + "B";
        return res;
    }
    public static void main(String[] args) {
        BullsandCows209 x = new BullsandCows209();
        System.out.println(x.getHint("1111", "0001"));
    }

}
