//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 811 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder == null || preorder.length == 0 )return null;
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    TreeNode build(int[] preorder , int x , int y,
                   int[] inorder , int a , int b){
        int root = preorder[x];
        TreeNode node = new TreeNode(root);
        int i = a;
        for(  ; i <= b ; i++){
            if( inorder[i] == root ) break;
        }
        if( i > a )
        node.left = build(preorder,x+1,x+i-a,
                inorder,a,i-1);
        if( i < b )
        node.right = build(preorder,x+1+i-a,y,
                inorder,i+1,b);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
