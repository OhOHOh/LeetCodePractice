import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class No149 {

    class Point {
        int x;
        int y;
        Point() { x=0; y=0; }
        Point(int a, int b) { x=a; y=b; }
    }

    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len < 3) {
            return len;
        }
        int maxNum = 0;
        for (int i = 0; i < len; i++) {
            int repeat = 1;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (points[i].x==points[j].x && points[i].y==points[j].y) {
                    repeat++;
                    continue;
                }
                String index = "";
                if (points[i].x == points[j].x) {
                    index = "INF";
                } else {
                    String a = String.valueOf(points[i].y - points[j].y);
                    String b = String.valueOf(points[i].x - points[j].x);
                    index = new BigDecimal(a).divide(new BigDecimal(b), 20, RoundingMode.HALF_UP).toString();
                }
                int count = 1;
                if (map.get(index) != null) {
                    count = map.get(index) + 1;
                }
                map.put(index, count);
            }// end for j
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() + repeat > maxNum) {
                    maxNum = entry.getValue() + repeat;
                }
            }
            maxNum = maxNum > repeat ? maxNum : repeat;
        }// end for i
        return maxNum;
    }
}
