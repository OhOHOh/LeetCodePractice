package No60;// 第60题，给出n、k，返回的是 n！个全排列 中的 第k个元素

public class No60 {
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n 不能是负数");
        }
        if (n == 0) {
            return 1;
        }
        return n*factorial(n-1);
    }

    public String getPermutation(int n, int k) {
        int partition = factorial(n-1);
        int index = k / partition + 1;
        int offset = k % partition;

        while (n > 0) {

        }


        return null;
    }
}
