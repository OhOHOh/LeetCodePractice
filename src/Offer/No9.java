package Offer;

/**
 * 斐波那契数列, 求第 n 项
 */

public class No9 {
    public static int f1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return f1(n-1) + f1(n-2);
    }

    public static int f2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] a = {0, 1, 1};

        while (n > 2) {
            a[0] = a[1] + a[2];
            a[1] = a[0] + a[2];
            a[2] = a[0] + a[1];
            n = n - 3;
        }

        return a[n % 3];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(f2(n));
    }
}
