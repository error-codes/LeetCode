/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/8/10 10:52
 */
public class _0027___RemoveElement {

    /**
     * 暴力解法
     *
     * @param nums 数组
     * @param val  目标数
     * @return 去重后数组长度
     */
    public int removeElement1(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不等于 val
            if (val != nums[i]) {
                // 将元素覆盖 index 位置
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 双指针解法
     *
     * @param nums 数组
     * @param val  目标数
     * @return 去重后数组长度
     */
    public int removeElement2(int[] nums, int val) {
        int slow = 0, fast = 0;
        // 慢指针位置没超过快指针，并且快指针没有到达数组末尾元素
        while (slow <= fast && fast < nums.length) {
            // 如果快指针的元素不等于目标数
            if (nums[fast] != val) {
                // 将快指针元素覆盖慢指针的元素
                nums[slow] = nums[fast];
                // 并且慢指针右移
                slow++;
            }
            // 无论快指针元素是否和目标数相等，此时快指针都该右移
            fast++;
        }
        return slow;
    }

    /**
     * 双指针优化解法
     *
     * @param nums 数组
     * @param val  目标数
     * @return 去重后数组长度
     */
    public int removeElement3(int[] nums, int val) {
        int head = 0, tail = nums.length - 1;
        // 头指针没有超过尾指针
        while (head <= tail) {
            // 如果头指针的元素等于目标数
            if (nums[head] == val) {
                // 将尾指针的元素覆盖头指针的元素, 并将尾指针左移一位
                nums[head] = nums[tail--];
            }
            // 如果头指针的元素不等于目标数
            else {
                // 头指针右移一位
                head++;
            }
        }
        return head;
    }
}
