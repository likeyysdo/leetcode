//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 417 👎 0


import jdk.swing.interop.SwingInterOpUtils;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if( matrix == null || matrix.length == 0
        || matrix[0].length == 0 ) return  new int[0];
        int ymax = matrix.length-1;
        int xmax = matrix[0].length-1;
        int x=0,y=0;
        int[] r = new int[matrix.length*matrix[0].length];
        int p = 0;
        while( x <= xmax && y <= ymax ){
            if( y == ymax ){
                for( int i = x ; i <= xmax ;i++ ){
                    r[p++] = matrix[y][i];
                }
                return r;
            }
            if( x == xmax ){
                for( int i = y ; i <= ymax ;i++ ){
                    r[p++] = matrix[i][x];
                }
                return r;
            }
            for( int i = x ; i < xmax  ;i++ ){
                r[p++] = matrix[y][i];
            }
            for( int i = y ; i < ymax ;i++ ){
                r[p++] = matrix[i][xmax];
            }
            for( int i = xmax ; i > x ;i--){
                r[p++] = matrix[ymax][i];
            }
            for( int i = ymax ; i > y  ;i-- ){
                r[p++] = matrix[i][x];
            }
            x++;y++;xmax--;ymax--;
        }

        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
