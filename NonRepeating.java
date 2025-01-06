import java.util.*;
public class NonRepeating {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++)
        {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(s.charAt(i), i);
        }

        int idx = Integer.MAX_VALUE;
        for(var e : map1.entrySet())
        {
            if(e.getValue() == 1)
            {
                idx = Math.min(idx, map2.get(e.getKey()));
            }
        }

        return idx == Integer.MAX_VALUE ? -1 : idx;
        
    }
}
