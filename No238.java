public class No238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        // 第一种方法 空间复杂度O(n), 时间复杂度O(n)
//        int[] left = new int[len];
//        int[] right = new int[len];
        // 初始化
//        left[0] = 1;
//        right[len-1] = 1;
//
//        for(int i = 1; i < len; i++) {
//            left[i] = left[i-1] * nums[i-1];
//        }
//        for(int i = len-2; i >= 0; i--) {
//            right[i] = right[i+1] * nums[i+1];
//        }
//
//        for(int i = 0; i < len; i++) {
//            result[i] = left[i] * right[i];
//        }
        // 第二种方法 空间复杂度O(1), 时间复杂度O(n)
        int left=1, right=1;
        for (int i = 0; i < len; i++) {
            result[i] = left;
            left = left * nums[i];
        }
        for (int i = len-1; i >= 0 ; i--) {
            result[i] *= right;
            right = right * nums[i];
        }
        
        return result;
    }
}
