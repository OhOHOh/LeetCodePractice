package No45;

public class No45 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int level=0, currentMax=0, i=0, nextMax=0;

        while (currentMax-i+1 > 0) {
            level++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i]+i);
                if (nextMax >= n-1) {
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return 0;
    }
}
