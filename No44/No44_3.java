package No44;

public class No44_3 {
    public boolean isMatch(String s, String p) {                // 贪心算法!!!
        int s_count=-1, p_count=-1;
        int i=0, j=0;

        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                s_count = i;
                p_count = j;
                j++;
            } else if (p_count != -1) {
                j = p_count + 1;
                s_count++;
                i = s_count;
            } else return false;
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return (j == p.length() && i == s.length());
    }

    public static void main(String args[]) {
        No44_3 test = new No44_3();
        String s = "zacabz";
        String p = "*a?b*";
        boolean result = test.isMatch(s, p);
        System.out.println(result);
    }

}
