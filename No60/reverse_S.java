package No60;

import java.util.Stack;

public class reverse_S {
    public String reverse_1(String input) {
        /**
         *  使用 java 中的 StringBuilder 所自带的 reverse() 函数来完成字符串的反转
         */
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
    public String reverse_2(String input) {
        /**
         *  使用递归的方法
         */
        if (input == null) {
            return null;
        }
        int len = input.length();
        if (len <= 1) {
            return input;
        }
        String left = input.substring(0, len/2);
        String right = input.substring(len/2, len);

        return reverse_2(right) + reverse_2(left);
    }

    public String reverse_3(String input) {
        /**
         *  取得当前字符并和之前的字符append起来, 空间换时间
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.insert(0, input.charAt(i));
        }
        return sb.toString();
    }

    public String reverse_4(String input) {
        /**
         *  使用二分交换, 比如第一个和最后一个进行交换
         */
        int len = input.length();
        int i=0, j=len-1;
        char[] array = input.toCharArray();

        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }

    public String reverse_5(String input) {
        /**
         *  使用 stack 来完成反转
         */
        char[] array = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        reverse_S test = new reverse_S();
        String input = "Yu Run-shen";
        System.out.println(test.reverse_5(input));
    }
}
