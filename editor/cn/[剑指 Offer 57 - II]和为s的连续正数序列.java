//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 445 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list= new ArrayList<>();
        int mid = target / 2;
        for( int i = mid ; i > 1 ; i--){
            if(  target * 2 ==  target * 2 / i * i ){
                int start2 = target * 2 / i + 1 - i ;
                if( start2 % 2 == 0 && start2 / 2 > 0){
                    int start = start2 / 2;
                    int[] temp = new int[i];
                    for( int p = 0;p<i;p++){
                        temp[p] = start++;
                    }
                    list.add(temp);
                }
            }
        }
        int[][] r = new int[list.size()][];
        for( int i = 0 ; i < r.length ; i++){
            r[i] = list.get(i);
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
