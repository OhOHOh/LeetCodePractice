import java.util.Arrays;

public class Sum3Closest {//第16题
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int start, end;
		int result = nums[0] + nums[1] + nums[nums.length-1];
		
		for(int i = 0; i < nums.length - 2; i++) {
			start = i + 1;
			end = nums.length - 1;
			
			if(result == target) {
				return result;
			}
			while(start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if(sum == target) {
					return sum;
				}
				if(sum < target) {
					start++;
				} else {
					end--;
				}
				if(Math.abs(sum-target) < Math.abs(result-target)) {
					result = sum;
				}
				
			}//while
		}
		return result;
	}
	
	public static void main(String args[]) {
		Sum3Closest test = new Sum3Closest();
		int[] nums = {0, 0, 0};
		System.out.println(test.threeSumClosest(nums, 1));
		
	}
}
