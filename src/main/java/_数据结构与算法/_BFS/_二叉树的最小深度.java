package _数据结构与算法._BFS;

import _数据结构与算法.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _二叉树的最小深度
 * @Author: lerry_li
 * @CreateDate: 2021/03/12
 * @Description
 */
public class _二叉树的最小深度 {
    int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //root本身就是一层，将depth初始化为1
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            //将当前队列的所有节点向下一层扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                //判断是否到达叶节点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                //将cur的子结点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            //增加层数
            depth++;
        }
        return depth;
    }
}
