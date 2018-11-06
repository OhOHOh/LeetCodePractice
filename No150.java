import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Stack;

public class No150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        int num1, num2;
        for (String token: tokens) {
//            if (token.equals("+") ||token.equals("-") ||token.equals("*") || token.equals("/")) {
//                int num1 = number.pop();
//                int num2 = number.pop();
//            }
            switch (token) {
                case "+":
                    num2 = number.pop();
                    num1 = number.pop();
                    number.push(num1+num2);
                    break;
                case "-":
                    num2 = number.pop();
                    num1 = number.pop();
                    number.push(num1-num2);
                    break;
                case "*":
                    num2 = number.pop();
                    num1 = number.pop();
                    number.push(num1*num2);
                    break;
                case "/":
                    num2 = number.pop();
                    num1 = number.pop();
                    number.push(num1/num2);
                    break;

                    default:
                        number.push(Integer.parseInt(token));
                        break;
            }
        }
        return number.pop();
    }

    public static void main(String[] args) {
        No150 test = new No150();
        String[] tmp = {"0", "3", "/"};
        System.out.println(test.evalRPN(tmp));
    }
}
