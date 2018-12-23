// TopK 问题, 使用 k个元素最小堆 来解决

public class No215 {
    private static int heap_length;
    public int findKthLargest(int[] nums, int k) {
        heap_length = k;
        buildHeap_siftdown(nums);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                siftdown(0, nums);
            }
        }

        return nums[0];
    }
    private static void siftdown(int i, int[] h) {
        /**
         *  最小堆 , 向下调整, 用于维护 堆, 保持堆的特性
         *  i 不断增加
         */
        int t;
        boolean flag = true;

        while (i*2+1 < heap_length && flag) {
            if (h[i] > h[i*2+1]) {  // 左节点比较
                t = i * 2 + 1;
            } else {
                t = i;
            }
            if (i*2+2 < heap_length && h[t] > h[i*2+2]) { // 右节点比较
                t = i * 2 + 2;
            }

            if (t == i) {
                flag = false;
            } else {  // 上面的 2 个 if 中至少有一个成立了
                int temp = h[i];
                h[i] = h[t];
                h[t] = temp;

                i = t;
            }
        }// while
    }
    private static void buildHeap_siftdown(int[] h) {
        /**
         * 使用 siftdown 的方法来构建 堆
         * 把数组 h 看作一个 完全二叉树!!! 时间复杂度 O(n)
         * @input:
         *      heap_length: 堆的长度
         *      h: 数组
         */
        int mid = (heap_length-2) / 2;
        for (int i = mid; i >= 0; i--) {
            siftdown(i, h);
        }
    }

}
