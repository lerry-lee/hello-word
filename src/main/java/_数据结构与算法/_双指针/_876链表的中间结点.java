package _数据结构与算法._双指针;

import _数据结构与算法.ListNode;

/**
 * @ClassName: _876链表的中间结点
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _876链表的中间结点 {
    /**
     * 快慢指针 时间O(N) 空间O(1)
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
