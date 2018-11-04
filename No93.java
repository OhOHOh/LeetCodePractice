import java.util.ArrayList;
import java.util.List;

public class No93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        dfs(s, "", 0, 0);

        return result;
    }
    public boolean isValid(String s) {
        if (s.charAt(0)=='0' && s.length() > 1) {
            return false;
        } else if (s.length() > 3) {
            return false;
        }
        int number = Integer.valueOf(s);
        if (number > 255) {
            return false;
        }
        return true;
    }
    public void dfs(String s, String addr, int count, int index) {
        // count 代表第几轮, 总共 0,1,2,3 轮
        if (count >= 3) {
            String seg = s.substring(index);
            if (isValid(seg)) {
                String ip = addr + seg;
                result.add(ip);
            }
            return;
        }
        for (int i = 1; i < 4 && index+i < s.length(); i++) {
            String seg = s.substring(index, index+i);
            if (isValid(seg)) {
                String ip = addr + seg + ".";
                dfs(s, ip, count+1, index+i);
            }
        }
    }

}
