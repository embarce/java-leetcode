package com.leetcode.arrayTest;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/13 21:04
 * Description:
 * FileName: AsteroidCollision
 */
public class AsteroidCollision {

    /**
     * 735. 行星碰撞
     * 给定一个整数数组 asteroids，表示在同一行的行星。
     * <p>
     * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
     * <p>
     * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
     * <p>
     * 输入：asteroids = [5,10,-5]
     * 输出：[5,10]
     * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
     * 示例 2：
     * <p>
     * 输入：asteroids = [8,-8]
     * 输出：[]
     * 解释：8 和 -8 碰撞后，两者都发生爆炸。
     * <p>
     * 示例 3：
     * <p>
     * 输入：asteroids = [10,2,-5]
     * 输出：[10]
     * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
     *
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

}
