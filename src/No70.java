public class No70 {
    public static int climbStairs(int n) {

        return dfs(n);
    }
    private static int dfs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return dfs(n-1) + dfs(n-2);
        }
    }

    public static int climbStairs2(int n) {
        if (n == 0 || n == 1 || n == 2){
            return n;
        }
        int[] ways = {0, 1, 2};
        for (int i = 2; i < n; i++) {
            ways[0] = ways[1];
            ways[1] = ways[2];
            ways[2] = ways[0] + ways[1];
        }
        return ways[2];
    }

    public static void main(String[] args) {
        int n = 44;
        System.out.println(climbStairs(n));
    }
}
