package com.leetcode.listnode;

import com.leetcode.vo.ListNode;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/20 11:06
 * Description: 排序链表
 * FileName: SortList
 */
public class SortList {

    /**
     * 148. 排序链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // 归并排序
    private static ListNode mergeSort(ListNode head) {
        // 如果没有结点/只有一个结点，无需排序，直接返回
        if (head == null || head.next == null) return head;
        // 快慢指针找出中位点
        ListNode slowp = head, fastp = head.next.next, l, r;
        while (fastp != null && fastp.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        // 对右半部分进行归并排序
        r = mergeSort(slowp.next);
        // 链表判断结束的标志：末尾节点.next==null
        slowp.next = null;
        // 对左半部分进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    // 合并链表
    private static ListNode mergeList(ListNode l, ListNode r) {
        // 临时头节点
        ListNode tmpHead = new ListNode(-1);
        ListNode p = tmpHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return tmpHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(3);
        one.next = two;
        two.next = three;
        three.next = four;
        System.out.println(sortList(one));
    }
}
