package _数据结构与算法._双指针;

import _数据结构与算法.ListNode;

/**
 * @ClassName: _142环形链表2
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
