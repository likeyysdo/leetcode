//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 441 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if( s == null || s.length() == 0) return 0;
        if( s.length() == 1) return 1;
        char[] chars = s.toCharArray();

        int max = 1;
        int start = 0;
        int[] p = new int[128];
        Arrays.fill(p,-1);
        p[chars[0]] = 0;
        for( int i = 1 ; i < chars.length ; i++){
            if( p[chars[i]] >= start ){
                start = p[chars[i]] + 1;
            }
            p[chars[i]] = i;
            int l = i - start + 1;
            max = max > l ? max : l;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
