package No60;

import java.math.BigInteger;
import java.util.*;

public class factorial {
    public int factorial_1(int n) {
        /**
         * 使用一个 for 循环计算 n 的阶乘
         */
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public int factorial_2(int n) {
        /**
         *  使用 递归 的思想来计算 n 的阶乘
         */
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (n == 0) {
            return 1;
        }

        return n * factorial_2(n-1);

    }

    static long[] table1 = new long[22];
    static {
        table1[0] = 1;
    }
    public long factorial_3(int n) {
        /**
         *  使用数组，为下一个方法做铺垫
         */
        if (n >= table1.length) {
            throw new IllegalArgumentException(" n 太大了");
        }

        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        int last = 0;
        while (last < n) {
            table1[last+1] = table1[last] * (last+1);
            last++;
        }

        return table1[n];
    }


    protected static ArrayList table = new ArrayList();
    static {
        table.add(BigInteger.valueOf(1));
    }
    public static synchronized BigInteger factorial_4(int n) {
        /**
         *  当数据很大，超过了 int 的范围的时候，如何计算？
         */
        for (int size = table.size(); size <= n; size++) {
            BigInteger lastfact = (BigInteger)table.get(size-1);
            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(size));
            table.add(nextfact);
        }

        return (BigInteger)table.get(n);
    }


    public static void main(String args[]) {
        factorial test = new factorial();
        int n = 9;
        System.out.println(test.factorial_1(n));
    }

}
