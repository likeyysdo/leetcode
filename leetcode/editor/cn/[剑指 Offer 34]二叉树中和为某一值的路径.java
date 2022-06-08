//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if( root == null ) return new ArrayList();
        //if( root.val == targetSum ) return new ArrayList();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<>();
        count(resultList,curList,root,targetSum,0);
        return resultList;
    }
    public void count( List<List<Integer>> resultList , List<Integer> curList , TreeNode node , int target ,int count){
        if( node == null || node.val > target - count ) return;
        curList.add(node.val);
        if( node.val == target - count && node.left == null && node.right == null ){
            List<Integer> list = new ArrayList<>(curList.size());
            list.addAll(curList);
            resultList.add(list);
        }
        count( resultList , curList , node.left , target , count + node.val );
        count( resultList , curList , node.right , target , count + node.val );
        curList.remove( curList.size() - 1 );
    }
}
//leetcode submit region end(Prohibit modification and deletion)
