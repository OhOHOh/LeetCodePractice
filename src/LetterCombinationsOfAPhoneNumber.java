import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber { //第17题
	public List<String> letterCombinations(String digits) {
		LinkedList <String> ans = new LinkedList<>();		
		ans.add("");
		if(digits.length()==0 || digits == null) {
			return ans; 
		}
		String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
	    for(int i = 0; i < digits.length(); i++) {
	    	int x = Character.getNumericValue(digits.charAt(i));
	    	
	    	while(ans.peek().length() == i) {
	    		String temp = ans.removeFirst();
	    		for(char s : map[x].toCharArray()) {
	    			ans.add(temp+s);
	    		}
	    	}	    	
	    }			    
	    return ans;
	}
	
}
