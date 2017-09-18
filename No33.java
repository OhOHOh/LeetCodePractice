public class No33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        if (target < nums[0] && target > nums[len-1]) {
            return -1;
        } else if (target >= nums[0]) { //从开始，从左往右查找
            for(int i = 0; i < len; i++) {
                if (target == nums[i]) {
                    return i;
                } else if (i == len-1 || target < nums[i+1] || nums[i] > nums[i+1]) {
                    // 肯定是 target > nums[i]，这个时候，什么情况下会返回-1呢？
                    return -1;
                }
            }
            return -1;
        } else {  //从最后，从右往左查找
            for (int i = len-1; i >= 0; i--) {
                if (target == nums[i]) {
                    return i;
                } else if (i == 0 || target > nums[i-1] || nums[i] < nums[i-1]){
                    // 肯定是 target < nums[i]，这个时候，什么情况下会返回-1呢？
                    return -1;
                }
            }
            return -1;
        }
    }
}
