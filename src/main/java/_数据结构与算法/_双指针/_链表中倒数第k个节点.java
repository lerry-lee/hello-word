package _数据结构与算法._双指针;

import _数据结构与算法.ListNode;

/**
 * @ClassName: _链表中倒数第k个节点
 * @Author: lerry_li
 * @CreateTime: 2021/03/22
 * @Description
 */
public class _链表中倒数第k个节点 {
    /**
     * 解法1：递归
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        res = null;
        dfs(head, k);
        return res;
    }

    static int kn;
    ListNode res;

    public void dfs(ListNode head, int k) {
        if (head == null) {
            return;
        }
        dfs(head.next, k);
        kn++;
        if (kn == k) {
            res = head;
        }
    }

    /**
     * 解法2：快慢双指针
     * */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        _链表中倒数第k个节点 instance = new _链表中倒数第k个节点();
        ListNode head = new ListNode(1);
        ListNode res = instance.getKthFromEnd(head, 1);
        System.out.println(res.val);
    }
}
