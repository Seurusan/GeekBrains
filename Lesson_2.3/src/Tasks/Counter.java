package Tasks;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    public static void startFirst() {
        String[] s = {
                "lemon", "banana", "melon", "pineapple", "melon",
                "cherry", "blueberry", "cherry", "cherry", "strawberry",
                "peach", "mango", "mango", "orange", "peach",
                "banana", "qiwi", "guawa", "banana", "banana"};
        Map<String, Integer> newmap = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            if (newmap.containsKey(s[i])) {
                newmap.put(s[i], newmap.get(s[i]) + 1);
            } else {
                newmap.put(s[i], 1);
            }
        }

        System.out.println(newmap);
    }
}
