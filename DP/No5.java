package DP;
//最长回文字串

import java.util.Scanner;

public class No5 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

//        System.out.println(input);
        System.out.println(longestPalindrome(input));

    } // main

    private static String longestPalindrome(String s) {
        /**
         * 求 s 的最长回文字串
         */
        int n = s.length();
        boolean[][] pal = new boolean[n][n];    //pal[i][j] 表示s[i...j]是否是回文串
//        for (int i = 0; i < n; i++) {
//            pal[i][i] = true;
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pal[i][j] = i >= j;
            }
        }
        int maxLen = Integer.MIN_VALUE;
        int rf=0, rt=0, k;  // k = 回文字串的长度-1

        for (k = 1; k < n; k++) {
            for (int i = 0; i+k < n; i++) {
                int j = i + k;
                if (s.charAt(i) != s.charAt(j)) {
                    pal[i][j] = false;
                } else {
                    pal[i][j] = pal[i+1][j-1];
                    if (pal[i][j] && maxLen < k+1) {
                        rf = i;
                        rt = j;
                        maxLen = k + 1;
                    }
                }
            }
        }

        return s.substring(rf, rt+1);
    }
}
