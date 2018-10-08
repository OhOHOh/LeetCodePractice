import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Sum4 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		//List<List<Integer>> ret = new ArrayList<List<Integer>>();
		LinkedHashSet<List<Integer>> ret = new LinkedHashSet<>();
		
		int p, q;
		for(int i = 0; i < nums.length - 3; i++) { //3Sum
			for(int j = i+1; j < nums.length - 2; j++) { //2Sum				
 				int temp = target - nums[i] - nums[j]; 			
 				
 				if(nums[j+1] + nums[j+2] > temp) { //TLE error
 					break;
 				}
 				
				p = j+1;
				q = nums.length - 1;
				while(p < q) {
					if(nums[p] + nums[q] == temp) {
						List<Integer> ans = new ArrayList<Integer>();
						ans.add(nums[i]);
						ans.add(nums[j]);
						ans.add(nums[p]);
						ans.add(nums[q]);
						ret.add(ans);
						p++;
						q--;
					} else if(nums[p] + nums[q] < temp) {
						p++;
					} else {
						q--;
					}
				}//while				
				
			}//for j 									
		}//for i
		
		List<List<Integer>> result = new ArrayList<List<Integer>>(ret);
		return result;
	}
}
