//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 👍 348 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int i = 0;
    public boolean isNumber(String s) {
        char[] tokens = s.toCharArray();
        while( i < tokens.length && tokens[i] == ' ' ) i++;
        if( i == tokens.length ) return false;

        int temp = i;
        if( !decimalCheck(tokens) ){
            i = temp;
            if( !digitalCheck(tokens) ){
                return false;
            }
        }
        if( i < tokens.length && (tokens[i] == 'e' || tokens[i] == 'E') ){
            i++;
            if( !digitalCheck(tokens) ){
                return false;
            }
        }
        while( i < tokens.length ){
            if( tokens[i++] != ' ' ) return false;
        }
        return true;
    }

    public boolean digitalCheck( char[] tokens ){
        if( i >= tokens.length ) return false;
        if( tokens[i] == '+' || tokens[i] == '-' ) {
            i++;
        }
        int count = 0;
        while( i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' ){
            count++;
            i++;
        }
        if( count == 0) return false;
        else return true;
    }

    public boolean decimalCheck( char[] tokens ){
        if( i >= tokens.length ) return false;
        if( tokens[i] == '+' || tokens[i] == '-' ) {
            i++;
        }
        if( i >= tokens.length ) return false;
        int count1 = 0;
        while( i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' ){
            count1++;
            i++;
        }
        if( i < tokens.length && tokens[i] == '.' ){
            i++;
        }
        int count2 = 0;
        while( i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' ){
            count2++;
            i++;
        }
        if( count1 != 0 || count2 != 0 ){
            return true;
        }else{
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
