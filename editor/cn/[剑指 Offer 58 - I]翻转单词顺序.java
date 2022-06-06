//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 双指针 字符串 👍 215 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] a = s.trim().toCharArray();
        char[] r = new char[a.length+1];
        int p = a.length-1;
        int q = 0;
        int c = 0;
        while( p >= 0 ){
            while( a[p] == ' ' )
                p--;
            if( p < 0 ) break;
            q = p;
            while( q >= 0 &&  a[q] != ' ' )
                q--;
            for( int i = q + 1 ; i <= p ; i++,c++){
                r[c] = a[i];
            }
            r[c++] = ' ';
            p = q;
        }
        if( c == 0 ) return "";
        else return String.valueOf(r,0,c-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
