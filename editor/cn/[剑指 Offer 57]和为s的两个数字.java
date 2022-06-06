//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 👍 190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if( nums == null || nums.length == 0 || nums.length == 1 ) return null;
        int start = 0;
        int end = nums.length-1;
        int p = nums[0];
        while( start < end ){
            if( p + nums[(start+end) / 2] > target ){
                end = (start+end) / 2;
            }else if( p + nums[(start+end) / 2] < target ){
                start = (start+end) / 2 + 1;
            }else{
                return new int[] { p , nums[(start+end) / 2] };
            }
        }
        start = 0;
        while ( start < end  ){
            int sum = nums[start] + nums[end];
            if( sum == target )
                return new int[] { nums[start] , nums[end] };
            else if( sum > target ){
                end--;
            }else start++;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
