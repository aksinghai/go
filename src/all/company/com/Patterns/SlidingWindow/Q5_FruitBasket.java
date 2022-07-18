package all.company.com.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;


public class Q5_FruitBasket {
    public static void main(String[] args) {
        char[] fruit = {'A', 'B', 'C', 'B', 'B', 'C'};
        int K = 2;
        System.out.println(maxFruitsInKDistinctBaskets(fruit, K));
    }

    private static int maxFruitsInKDistinctBaskets(final char[] fruit, final int k) {
        Map<Character, Integer> charLookup = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < fruit.length){
            char headChar = fruit[j];
            if(charLookup.containsKey(headChar)){
                charLookup.put(headChar,charLookup.get(headChar)+1);
                max = Integer.max(max, (j-i+1));
                j++;
            } else {
                if(charLookup.size() == k) {
                    char backChar = fruit[i];
                    int c = charLookup.get(backChar);
                    if (c == 1) {
                        charLookup.remove(backChar);
                    } else {
                        charLookup.put(backChar, charLookup.get(backChar) - 1);
                    }
                    i++;
                } else {
                    charLookup.put(headChar, 1);
                    max = Integer.max(max, (j-i+1));
                    j++;
                }
            }
        }
        return max;
    }
}
