package No45;

public class No45_2 {
//    private int fun(int pos, int level, int[] nums, int len) {
//        // pos 是当前的位置, level 是已经走的步数, nums 是数组, len 是数组的长度
//        for (int i = 1; i <= nums[pos]; i++) {
//            int nextPos = pos + i;
//            if (nextPos >= len - 1) {
//                return (level + 1);
//            } else {
//                fun(nextPos, level+1, nums, len);
//            }
//        }
//    }


    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int level=0, i=0, nextMax=0, currentMax=0;

        while (true) {
            for (;i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i]+i);
                if (nextMax >= nums.length-1) {
                    return (level+1);
                }
            }
            currentMax = nextMax;
            level++;
        }
    }


    public static void main(String[] args) {
        No45_2 test = new No45_2();
        int[] nums = {1, 2, 1, 1, 1};
        int result = test.jump(nums);
        System.out.println(result);
    }
}
