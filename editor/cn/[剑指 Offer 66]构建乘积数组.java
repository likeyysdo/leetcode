//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 237 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        for(int i = 0,p = 1; i <n ;p *= a[i],i++){
            r[i] = p;
        }
        for(int i = n-1,p = 1; i >= 0 ;p *= a[i],i--){
            r[i] *= p;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
