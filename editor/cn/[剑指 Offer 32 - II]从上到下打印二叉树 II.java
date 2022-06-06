//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 229 👎 0


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
        ArrayList<List<Integer>> list = new ArrayList<>();
        if( root == null ) return list;
        Deque<TreeNode> deque1= new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque1.offer(root);
        while(!deque1.isEmpty() || !deque2.isEmpty() ){
            Deque<TreeNode> cur;
            Deque<TreeNode> next;
            if( !deque1.isEmpty() ){
                cur = deque1;
                next = deque2;
            }else{
                cur = deque2;
                next = deque1;
            }
            ArrayList<Integer> l1 = new ArrayList<>();

            while( !cur.isEmpty() ){
                TreeNode t = cur.poll();
                l1.add(t.val);
                if( t.left != null ) next.offer(t.left);
                if( t.right != null ) next.offer(t.right);
            }
            list.add(l1);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
