package DP;

import java.util.Stack;

public class No32 {
    public static void main(String args[]) {
        String s = ")())(";
        System.out.println(longestValidParenthesesDP(s));
    }
    private static int longestValidParentheses(String s) {
        /**
         * 暴力搜索
         */
        char[] ch = s.toCharArray();
        int len = ch.length;
        int max = 0;

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
//                if (isCorrect(ch, i, j)) {
//                    max = Math.max(max, j-i+1);
//                }
                switch (isCorrect(ch, i ,j)) {
                    case -1: break;
                    case -2: continue;
                    case -3: max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    private static int isCorrect(char[] ch, int start, int end) {
        /**
         * 返回值的含义：
         *      -1: start == ')', i++
         *      -2: end == '(', or just fail, j++
         *      -3: success
         */
//        if (ch[start] == ')' || ch[end] == '(') {
//            return false;
//        }
        if (ch[start] == ')') {
            return -1;
        }
        if (ch[end] == '(') {
            return -2;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(ch[start++]);

        while (start <= end) {
            if (ch[start] == ')') {
                if (stack.empty()) {
                    return -2;
                }
                stack.pop();
            } else {
                stack.push(ch[start]);
            }
            start++;
        }

        //return stack.empty();
        if (stack.empty()) {
            return -3;
        } else {
            return -2;
        }
    }

    private static int longestValidParentheses2(String s) {
        /**
         * 使用 stack 来求解, 记录上一个匹配成功的位置 last, 如果失败, 就更新 last, 在这个过程里，不断更新 max
         *
         * */
         char[] ch = s.toCharArray();
         Stack<Integer> stack = new Stack<>();
         int max = 0, last = 0;
         int n = ch.length;

         for (int i = 0; i < n; i++) {
             if (ch[i] == '(') {
                 stack.push(i);
             } else {// ch[i] == ')'
                 if (stack.empty()) {
                     last = i + 1;
                 } else { // 起码当前成功匹配了部分
                     stack.pop();
                     if (stack.empty()) {
                         max = Math.max(max, i-last+1);
                     } else {
                         max = Math.max(max, i-stack.peek());
                     }
                 }
             }
         }

         return max;
    }// longestValidParentheses2

    private static int longestValidParenthesesDP(String s) {
        /**
         * DP, dp[i] 表示以 ch[i] 为结尾的符合条件的最大字串的 长度
         */
        if (s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length];
        dp[0] = 0;

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == '(') {
                dp[i] = 0;
                continue;
            }
            // ch[i] == ')'
            if (dp[i-1] == 0) {  // ch[i-1] == '('  or just fail
                dp[i] = dp[i-1];
                if (ch[i-1] == '(') {
                    dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                    if (i > dp[i]) {
                        dp[i] += dp[i-dp[i]];
                    }
                }
            } else { // dp[i-1] != 0
                if (i-1-dp[i-1] >= 0 && ch[i-1-dp[i-1]] == '(') {
                    dp[i] = dp[i-1] + 2;
                    if (i > dp[i]) {
                        dp[i] += dp[i-dp[i]];
                    }
                } else {
                    dp[i] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < ch.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
