public class No65 {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 1) {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }

        char[] ch = s.toCharArray();
        int len = ch.length;
        boolean findE = false;
        boolean findPointBeforeE = false;
        boolean findPointAfterE = false;
        if (ch[0] != '-' && (ch[0] < '0' || ch[0] > '9') && ch[0] != '.') {
            return false;
        }
        if (ch[0] == '.') {
            findPointBeforeE = true;
        }
        for (int i = 1; i < len; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                continue;
            }
            if (ch[i] == 'e') {
                if (!findE) {
                    findE = true;
                    continue;
                } else {
                    return false;
                }
            }
            if (ch[i] == '.') {
                if (!findPointBeforeE) {
                    findPointBeforeE = true;
                } else if (findE && !findPointAfterE) {
                    findPointAfterE = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
