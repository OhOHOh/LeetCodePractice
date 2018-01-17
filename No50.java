public class No50 {
    public double myPow1(double x, int n) {     //会超时
        double result = 1.0;

        if (n == 0) {
            return result;
        }

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
            return result;
        }

        for (int i = 0; i < (-n); i++) {
            result *= x;
        }
        return 1/result;
    }

    public double myPow2(double x, int n) {   //把 x 乘起来
        double ans = 1.0;
        long absN = Math.abs((long)n);
        while (absN > 0) {
            if ((absN & 1) == 1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }

        return n < 0 ? 1/ans : ans;
    }
}
