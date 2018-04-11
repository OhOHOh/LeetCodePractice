package No44;

public class No44_2 {
    public boolean isMatch(String s, String p) {
        // 用深度递归的方法



        return true;
    }


    public boolean fun(String s, String p) {
        int m=0, n=0;

        while (m < s.length() && n < p.length()) {
            if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '?') {
                m++;
                n++;
            } else {
                break;
            }
        }

        return !(m < s.length() || n < p.length());
    }
}
