package DP;

import java.util.Stack;

public class No32 {
    public static void main(String args[]) {
        String s = ")())(";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
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
                    return -4;
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
}
