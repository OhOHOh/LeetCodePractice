import java.util.Arrays;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class No322 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length==0 || coins==null) {
            return -1;
        }
        if (coins.length == 1) {
            if (amount % coins[0] == 0) {
                return (amount/coins[0]);
            } else {
                return -1;
            }
        }
        // 正常操作
        Arrays.sort(coins);

        return coinChangeHelper(coins, amount, new int[amount]);
    }

    private int coinChangeHelper(int[] coins, int amount, int[] tmp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (tmp[amount-1] != 0) {
            return tmp[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int rtn = coinChangeHelper(coins, amount-coin, tmp);
            if (rtn >= 0) {
                min = Math.min(min, rtn+1);
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount-1];
    }
}