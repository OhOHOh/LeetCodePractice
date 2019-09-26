import java.util.HashSet;
import java.util.Set;

public class No128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 1,5};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int rtn = 0;
        int len;
        for (Integer num: nums) {
            len = 1;
            if (set.remove(num)) {
                //向左找连续的数字
                int current = num;
                while (set.remove(current-1)) {
                    current = current - 1;
                }
                len += num - current;
                //向右找连续的数字
                current = num;
                while (set.remove(current+1)) {
                    current = current + 1;
                }
                len += current - num;
                rtn = Math.max(rtn, len);
            }
        }//for
        return rtn;
    }
}
