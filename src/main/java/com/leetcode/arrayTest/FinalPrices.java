package com.leetcode.arrayTest;

/**
 * @author Embrace
 * @Classname FinalPrices
 * @Description FinalPrices 1475. 商品折扣后的最终价格
 * @Date 2022/9/1 22:24
 * @git: https://github.com/embarce
 */
public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int discount = 0;
            for (int j = i + 1; j < n; ++j) {
                if(prices[j] <= prices[i]){
                    discount = prices[j];
                    break;
                }
            }
            ans[i] = prices[i] - discount;
        }
        return ans;
    }
}
