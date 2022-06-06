//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 202 👎 0


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
    public int[] levelOrder(TreeNode root) {
        if( root == null ) return  new int[0];
        ArrayList<Integer> list = new ArrayList();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            TreeNode cur = deque.poll();
            list.add(cur.val);
            if( cur.left != null ) deque.offer(cur.left);
            if( cur.right != null ) deque.offer(cur.right);
        }
        int[] r = new int[list.size()];
        for( int i = 0 ; i < r.length ; i++ ){
            r[i] = list.get(i);
        }
        return  r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
