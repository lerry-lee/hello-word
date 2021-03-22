package _数据结构与算法._双指针;

import _数据结构与算法.ListNode;

/**
 * @ClassName: _141环形链表
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _141环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast!=null&&fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
