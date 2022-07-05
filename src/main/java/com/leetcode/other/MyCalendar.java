package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/5 20:38
 * Description: 729. 我的日程安排表 I
 * FileName: MyCalendar
 */
public class MyCalendar {

    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }

    /**
     * 直接遍历
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
