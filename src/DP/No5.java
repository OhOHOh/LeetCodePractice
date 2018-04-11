package DP;
//最长回文字串

import java.util.Scanner;

public class No5 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(input);
        System.out.println(longestPalindrome(input));

    } // main

    private static String longestPalindrome(String s) {
        /**
         * 求 s 的最长回文字串
         */
        int n = s.length();
        boolean[][] pal = new boolean[n][n];    //pal[i][j] 表示s[i...j]是否是回文串
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }
        int maxLen = Integer.MIN_VALUE;
        int start_S=0, end_S=0;

        for (int end = 0; end < n; end++) {
            int start = end;

            while (start >= 0) {
                if ((s.charAt(start) == s.charAt(end)) && (end-start < 2 ||pal[start+1][end-1])) {
                    pal[start][end] = true;
                    if (maxLen < end-start+1) {
                        maxLen = end-start+1;
                        start_S = start;
                        end_S = end;
                    }
                    start--;
                }
            }// while
        }

        return s.substring(start_S, end_S+1);
    }
}
