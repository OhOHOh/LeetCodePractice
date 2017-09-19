public class No34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }

        int l = 0, r = nums.length-1;
        int m = (l + r) / 2;

        // 先找到一个 target，再分2个方向进行扩展
        while (l <= r) {
            m=(l + r) / 2;
            if (nums[m] == target) {
                res[0] = m;
                res[1] = m;
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        } //while
        if (res[0] == -1) { // 根本没有找到 target
            return res;
        }

        // 再寻找右边界
        int newL = m, newR = nums.length-1;
        while (newL <= newR) {
            int newM = (newL + newR) / 2;
            if (nums[newM] == target) {
                newL = newM + 1;
            } else {
                newR = newM - 1;
            }
        }
        res[1] = newR;

        // 寻找左边界
        newL = 0;
        newR = m;
        while (newL <= newR) {
            int newM = (newL + newR) / 2;
            if (nums[newM] == target) {
                newR = newM - 1;
            } else {
                newL = newM + 1;
            }
        }
        res[0] = newL;

        return res;
    }

    // 由 1 改进而来，只需要进行2次二分查找，第一次二分查找可以不用。 通过
    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }

        int l = 0, r = nums.length-1;
        int m = (l + r) / 2;

        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                int ll=0, lr=m, lm, rl=m, rr=nums.length-1, rm;

                // 找左边界
                while (ll <= lr) {
                    lm = (ll + lr) / 2;
                    if (nums[lm] == target) {
                        lr = lm - 1;
                    } else {
                        ll = lm + 1;
                    }
                }
                res[0] = ll;

                // 找右边界
                while (rl <= rr) {
                    rm = (rl + rr) / 2;
                    if (nums[rm] == target) {
                        rl = rm + 1;
                    } else {
                        rr = rm - 1;
                    }
                }
                res[1] = rr;

                return res;

            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        } // while

        return res;
    }

}
