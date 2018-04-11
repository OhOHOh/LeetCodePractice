package No60;

import java.math.BigDecimal;

public class tran_S_to_I {
    public int category_1(String input) {
        /**
         *  一般的正整数的情况
         */
        input = new StringBuilder(input).reverse().toString();
        char[] array = input.toCharArray();
        int result = 0;
        for (int i=0, k=1; i < array.length; i++,k=k*10) {
            result = result + (array[i]-'0') * k;
        }
        return result;
    }

    public int category_2(String input) {
        /**
         *  如果存在负数
         */
        boolean neg = false;    //负号是否存在
        if (input.charAt(0) == '-') {
            neg = true;
            input = input.substring(1);
        }
        // return category_1(input);
        input = new StringBuilder(input).reverse().toString();
        char[] array = input.toCharArray();
        int result = 0;
        for (int i=0, k=1; i < array.length; i++,k=k*10) {
            result = result + (array[i]-'0') * k;
        }

        if (neg) {
            result = -result;
        }
        return result;
    }

    public double category_3(String input) {
        /**
         *  如果存在小数点, 那么返回结果是 double 类型的
         */
        boolean neg = false;    //负号是否存在
        if (input.charAt(0) == '-') {
            neg = true;
            input = input.substring(1);
        }

        boolean point = false;  //小数点是否存在
        int point_index = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                point = true;
                point_index = i;
                break;
            }
        }

        if (point) {
            String integer_s = input.substring(0,point_index);
            String decimal_s = input.substring(point_index+1);
            int integer_i = category_1(integer_s);
            double decimal_d = com_decimal(decimal_s);
            if (neg) {
                return -(integer_i+decimal_d);
            } else {
                return (integer_i+decimal_d);
            }
        } else {
            return category_2(input);
        }

    }

    private double com_decimal(String input) {
        /**
         *  传入的字符串是小数部分的, 返回的也是一个 double 类型的数据, 并且小于 1
         */
        BigDecimal result = new BigDecimal("0");
        BigDecimal k = new BigDecimal("0.1");
        BigDecimal a = new BigDecimal("0.1");
        for (int i=0; i < input.length(); i++,k=k.multiply(a)) {
            //result = result + (array[i]-'0') * k.doubleValue();
            BigDecimal number = new BigDecimal(input.charAt(i)-'0');
            BigDecimal temp = k.multiply(number);
            result = result.add(temp);
        }
        return result.doubleValue();
    }

    public static void main(String args[]) {
        tran_S_to_I test = new tran_S_to_I();
        String input = "-123.123";
        System.out.println(test.category_3(input));
        //System.out.println(test.com_decimal(input));

//        double k = 0.1;
//        for (int i = 0; i < 3; i++) {
//            System.out.println(k);
//            k = k * 0.1;
//        }
    }
}
