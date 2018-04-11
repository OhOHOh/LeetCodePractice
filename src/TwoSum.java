import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				result[0] = map.get(target-nums[i]);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}
	public int[] twoSumBrute(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] {i ,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String args[]) {
		TwoSum test = new TwoSum();
		
		int[] nums = {3,2,4};
		int[] result = test.twoSumBrute(nums, 6);
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

}
