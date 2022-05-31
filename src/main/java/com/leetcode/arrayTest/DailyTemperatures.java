package com.leetcode.arrayTest;

import java.util.Stack;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/31 10:26
 * Description: 每日温度
 * FileName: DailyTemperatures
 */
public class DailyTemperatures {


    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     * <p>
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param temperatures
     * @return
     */
    /**
     * 暴力ac
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if (temperatures.length == 1) {
            return res;
        }
        for (int i = 0; i < temperatures.length; i++) {
            int todayTemperature = temperatures[i];
            int count = 0;
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[j]>todayTemperature){
                    count=j-i;
                    break;
                }
            }
            res[i]=count;
        }
        return res;
    }


    /**
     * 单调栈
     * 可以维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperaturesByStack(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
