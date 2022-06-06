//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 230 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if( root == null ) return  result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int count = 1;
        boolean l2r = true;

        ArrayList<Integer> list ;
        while(!deque.isEmpty()){
            list = new ArrayList();
            int temp = 0;
            for( int i = 0 ; i < count ; i++){
                if( l2r ){
                    TreeNode cur = deque.poll();
                    list.add(cur.val);
                    if( cur.left != null ) {
                        deque.offer(cur.left);temp++;
                    }
                    if( cur.right != null ) {
                        deque.offer(cur.right);temp++;
                    }
                }else{
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);

                    if( cur.right != null ) {
                        deque.offerFirst(cur.right);temp++;
                    }
                    if( cur.left != null ) {
                        deque.offerFirst(cur.left);temp++;
                    }
                }
            }
            l2r = !l2r;
            count = temp;
            result.add(list);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
