import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class No42 {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int area = 0;
        List<Integer> peak = new ArrayList<>();
        if (height[0] > height[1]) {
            peak.add(0);
        }

        for (int i = 1; i < height.length; i++) {
            if ((height[i] >= height[i-1] && height[i] > height[i+1]) ||
                    ((i==height.length-1) && (height[height.length-2] < height[height.length-1]))) {
                peak.add(i);
                // 对 peak 进行筛选, 头尾不需要
                if (peak.size() > 2) {
                    for (int j = 1; j < peak.size()-1; j++) {
                        if (height[i] > height[peak.get(j)]) {
                            peak.remove(j);
                            j--;
                        }
                    }
                }
            }
        }
//        // 对 peak 进行筛选, 头尾不需要
//        boolean yes = true;
//        while (yes) {
//            yes = false;
//            for (int i = 1; i < peak.size()-1; i++) {
//                if (height[peak.get(i)] < height[peak.get(i-1)] && height[peak.get(i)] < height[peak.get(i+1)]) {
//                    peak.remove(i);
//                    yes = true;
//                }
//            }
//        }


        for (int i = 0; i < peak.size()-1; i++) {
            area += betweenPeak(height, peak.get(i), peak.get(i+1));
        }
        return area;
    }

    /**
     *  计算 2 个 Peak 之间的水的面积
     * @param height
     * @param i
     * @param j > i
     * @return area
     */
    private int betweenPeak(int[] height, int i, int j) {
        int area = 0;
        int min = height[i] < height[j] ? height[i] : height[j];

        area = (j-i-1) * min;
        for (int k = i+1; k < j; k++) {
//            if (height[k] <= height[j]) {
//                area -= height[k];
//            } else {
//                area -= height[j];
//            }
            area -= (height[k] <= height[j]) ? height[k] : height[j];
        }
        return area;
    }


    public int trap2(int[] height) {
        int a = 0, b = height.length-1;
        int max = 0;
        int leftmax = 0, rightmax = 0;
        while (a <= b) {
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if (leftmax < rightmax) {
                max += (leftmax - height[a]);
                a++;
            } else {
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No42 test = new No42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // int[] height = {5,2,1,2,1,5};
        int area = test.trap2(height);
        System.out.println(area);
    }
}
