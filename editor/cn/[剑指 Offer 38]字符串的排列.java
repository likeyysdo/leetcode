//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 566 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] r = null;
    int count = 0;
    public String[] permutation(String s) {
        char[] c = s.toCharArray();
        boolean[] o = new boolean[c.length];
        char[] temp = new char[c.length];
        int sum = 1;
        for( int i = 1; i <= c.length ;i++){
            sum *= i;
        }
        r = new String[sum];
        fun(c,temp,0,o);
        return Arrays.copyOf(r,count);
    }
    public void fun(char[] c,char[] temp, int temp_p , boolean[] o){
        if( temp_p == temp.length ){
            r[count++] = String.valueOf(temp);
            return;
        }
        boolean[] char1 = new boolean[128];

        for( int i = 0 ; i < o.length ; i++ ){
            if(!o[i] && !char1[c[i]] ){
                o[i] = true;
                temp[temp_p] = c[i];
                fun(c,temp,temp_p+1,o);
                o[i] = false;
                char1[c[i]] = true;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
