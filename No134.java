public class No134 {
    public int canCompleteCircuit_1(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }

        int len = gas.length;
        for (int start=0; start < len; start++) {
            if (isValid(gas, cost, start)) {
                return start;
            }
        }

        return -1;
    }
    public boolean isValid(int[] gas, int[] cost, int start) {
        // 判断起点start是否满足条件
        int curGas = gas[start], now=start;
        for (int i = 0; i < gas.length; i++) { //必须进行多少次的循环
            if (curGas - cost[now] >= 0) { //车辆能够到达下一站
                int next = (now+1) % gas.length;
                curGas = curGas - cost[now] + gas[next];
                now = next;
            } else {
                return false;
            }
        }
        return true;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0, total=0, start=0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) { // 车辆不能到达下一站
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return tank+total<0 ? -1 : start;
    }

    public static void main(String[] args) {
        No134 test = new No134();
        int[] gas = {3,3,4};
        int[] cost = {3,4,4};
        System.out.println(test.canCompleteCircuit_1(gas, cost));
    }
}
