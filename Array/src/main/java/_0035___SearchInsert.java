/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/8/10 11:25
 */
public class _0035___SearchInsert {

    /**
     * 暴力解法
     *
     * @param nums   数组
     * @param target 目标数
     * @return 插入位置
     */
    public int searchInsert1(int[] nums, int target) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素大于目标数，直接返回当前位置
            if (nums[i] >= target) {
                return i;
            }
        }
        // 如果遍历完整个数组，没有合适位置，证明目标数超过数组中最大元素的值
        // 也就是尾端元素的值，返回末尾下标 + 1，即 nums.length
        return nums.length;
    }

    /**
     * 二分查找解法
     *
     * @param nums   数组
     * @param target 目标数
     * @return 插入位置
     */
    public int searchInsert2(int[] nums, int target) {
        int head = 0, tail = nums.length - 1;
        // 如果头指针没有超过尾指针
        while (head <= tail) {
            // 获取中间位置下标
            int mid = head + tail >> 1;
            // 如果中间元素值等于目标数
            if (nums[mid] == target) {
                // 返回中间元素下标
                return mid;
            }
            // 如果中间元素值小于目标数
            if (nums[mid] < target) {
                // 头指针要右移至中间元素的右边一位，即 mid + 1 处
                head = mid + 1;
            }
            // 如果中间元素值大于目标数
            else {
                // 尾指针要左移至中间元素的左边一位，即 mid - 1 处
                tail = mid - 1;
            }
        }
        return head;
    }
}
