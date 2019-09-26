public class No5 {
    public static void main(String[] args) {
        String s = "cbbcbbc";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if (s==null || s.length()==0) {
            return null;
        }
        int len = s.length();
        int low=0, high=0, max=0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = i>=j;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                    if (max < j-i+1) {
                        max = j-i+1;
                        low = i;
                        high = j;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(low, high+1);
    }
}
