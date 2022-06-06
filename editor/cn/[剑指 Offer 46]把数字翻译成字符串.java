//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 446 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        if (num == 0) return 1;
        if (num < 10) return 1;
        char[] array = String.valueOf(num).toCharArray();
        int[] result = new int[array.length];
        result[0] = 1;
        if( array[0] == '1' ||
                array[0] == '2' && array[1] < '6' ){
            result[1] = 2;
        }else{
            result[1] = 1;
        }
        for( int i = 2 ; i < array.length ; i++ ){
            if( array[i-1] == '1' ||
                    array[i-1] == '2' && array[i] < '6' ){
                result[i] = result[i-1] + result[i-2];
            }else{
                result[i] = result[i-1];
            }
        }
        System.out.println(Arrays.toString(result));
        return result[result.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
