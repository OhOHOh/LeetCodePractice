import java.util.*;

public class No3 {
    public static int lengthOfLongestSubstringKDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int low = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                low = Math.max(low, map.get(s.charAt(i))+1)
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-low+1);
        }
        return max;
    }

    public static void main(String[] args) {
        No3 test = new No3();
        String s = "abcdabc";
        System.out.println(test.lengthOfLongestSubstringKDistinct(s));
    }
}