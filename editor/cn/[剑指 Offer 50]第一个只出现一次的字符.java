//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 235 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if( s == null || s.length() == 0) return ' ';
        int[] array = new int[128];
        for( char c : s.toCharArray() ){
            array[c]++;
        }
        for( char c : s.toCharArray() ){
            if( array[c] == 1 ) return c;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
