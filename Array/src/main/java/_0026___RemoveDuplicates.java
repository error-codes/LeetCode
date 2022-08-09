/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/8/9 17:07
 */
public class _0026___RemoveDuplicates {


    /**
     * 暴力解法
     *
     * @param nums 数组
     * @return 去重长度
     */
    public int removeDuplicates1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果为数组起始位置或当前位置元素不等于
            if (index < 1 || (nums[i] != nums[index - 1])) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 双指针解法
     *
     * @param nums 数组
     * @return 去重长度
     */
    public int removeDuplicates2(int[] nums) {
        int slow = 0, fast = 0;

        // 如果慢指针超过快指针或快指针到数组末尾
        while (slow <= fast && fast < nums.length) {
            // 如果快慢指针元素不等
            if (nums[slow] != nums[fast]) {
                // 慢指针先右移一位
                slow++;
                // 再将快指针的元素覆盖至慢指针右移一位后的元素
                nums[slow] = nums[fast];
            } else {
                // 快慢指针元素相等，快指针右移一位
                fast++;
            }
        }
        // 因为指针是从下标元素 0 开始的，但返回的是长度，所以要进行 +1 操作
        return slow + 1;
    }
}
