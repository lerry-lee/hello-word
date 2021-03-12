# 广度优先遍历BFS

## 算法框架

在一个图中，计算起点`start`到终点`end`的最短距离，假设任意连线的距离为1

```java
    //计算从起点start到终点end的最短距离，用一个队列实现
    int BFS(Node start,Node end){
        Queue<Node> q;//队列,先进先出
        Set<Node> visited;//记录已访问过的节点，避免走回头路
        
        q.offer(start);//将起点加入队列
        visited.add(start);//起点设为已访问
        int step=0;//记录扩散的步数
        
        while(!q.isEmpty()){
            int size=q.size();
            //将当前队列中的所有节点向四周扩散
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                //重点：这里要判断是否到达终点，到达则已经找到最短路径
                if(cur==end){
                    return step;    
                }
                //否则，将cur的相邻节点加入队列
                for(Node x:cur.adj()){
                    if(!visited.contains(x)){
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            //重点：这里更新步数
            step++;
        }
    }
```

## 求二叉树的最小高度

```java
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
```