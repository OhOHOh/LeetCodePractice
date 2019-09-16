public class No4 {
    /*
    找出2个有序数组num1,nums2中的中位数!
     */
    public static void main(String[] args) {
        int[] nums1 = {5,7};
        int[] nums2 = {6,8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        double tmp1 = getKth(nums1, 0, n-1, nums2, 0, m-1, left);
        double tmp2 = getKth(nums1, 0, n-1, nums2, 0, m-1, right);
        return (tmp1 + tmp2)/2;
    }
    private static int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        if (len1 > len2) { //保证 len1 < len2
            return getKth(nums2, s2, e2, nums1, s1, e1, k);
        }
        if (len1 == 0) {
            return nums2[k+s2-1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int i = s1 + Math.min(len1, k/2) - 1;
        int j = s2 + Math.min(len2, k/2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i+1, e1, nums2, s2, e2, k-(i-s1+1));
        } else {
            return getKth(nums1, s1, e1, nums2, j+1, e2, k-(j-s2+1));
        }
    }
}
