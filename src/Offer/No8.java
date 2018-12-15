package Offer;

/**
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素
 */
public class No8 {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int mid = left;

        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right ) / 2;

            // 如果下标 left right mid 所指向的数字都一样, 那么只能进行顺序查找
            if (array[mid] == array[left] && array[mid] == array[right]) {
                return MinInOrder(array, left, right);
            }

            if (array[mid] < array[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return array[mid];
    }
    private static int MinInOrder(int[] array, int left, int right) {
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array));
    }
}
