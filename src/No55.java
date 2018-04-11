import java.util.ArrayList;
import java.util.List;

public class No55 {
	private boolean result = false;
	
	public boolean canJump(int[] nums) {
        int last = nums.length - 1;
		
		for (int i = last-1; i >= 0; i--) {
			if (i + nums[i] >= last) {
				last = i;
			}
		}
		
		return (last <= 0);
    }
}
