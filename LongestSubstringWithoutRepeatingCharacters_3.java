import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	public int lengthOfLongestSubstring_1(String s) {
		//只适合String类型中只含有小写字母的情况
		int maxLen = 0;
		int begin = 0;
		int[] alphabet = new int[26];
		for(int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}
		
		for(int i = 0; i < s.length(); i++) {
			int tempi = s.charAt(i) - 'a';
			if(alphabet[tempi] != -1) {
				int temp = i - begin;
				maxLen = (maxLen > temp ? maxLen : temp);
				begin = alphabet[tempi] + 1;
				for(int j = 0; j < 26; j++) {
					alphabet[j] = -1;
				}
				alphabet[begin] = i + 1;
			} else {
				alphabet[tempi] = i;
			}
		}
		int tempLen = s.length() - 1 - begin;
		maxLen = (maxLen > tempLen ? maxLen : tempLen);
		System.out.println(begin);
		
		return maxLen;
	}
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0)
			return 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		
		for(int i = 0, j = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
		}
		return max;
	}
	
	public static void main(String args[]) {
		LongestSubstringWithoutRepeatingCharacters_3 test = new LongestSubstringWithoutRepeatingCharacters_3();
		
		String s = "pwwkewdhklasjgobgsd";
		System.out.println(test.lengthOfLongestSubstring(s));
	}

}
