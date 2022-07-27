package com.leetcode.strTest;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/27 21:02
 * Description:
 * FileName: FractionAddition
 */
public class FractionAddition {

    /**
     * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
     * <p>
     * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
     * <p>
     * <p>
     * 输入: expression = "-1/2+1/2"
     * 输出: "0/1"
     *  示例 2:
     * <p>
     * 输入: expression = "-1/2+1/2+1/3"
     * 输出: "1/3"
     * 示例 3:
     * <p>
     * 输入: expression = "1/3-1/2"
     * 输出: "-1/6"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1; // 分子，分母
        int index = 0, n = expression.length();
        while (index < n) {
            // 读取分子
            long denominator1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator1 = sign * denominator1;
            index++;

            // 读取分母
            long numerator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator), numerator); // 获取最大公约数
        return Long.toString(denominator / g) + "/" + Long.toString(numerator / g);
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

}
