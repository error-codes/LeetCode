import java.util.Arrays;
import java.util.Collections;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/8/10 17:17
 */
public class _0088___MergeTwoArray {


    /**
     * 暴力解法
     *
     * @param nums1 数组1
     * @param m     有效容量
     * @param nums2 数组2
     * @param n     有效容量
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 先将 nums2 中元素复制到 nums1 中
        for (int num2 : nums2) {
            nums1[m++] = num2;
        }

        // 对 nums1 中元素排序
        for (int j = 0; j < nums1.length; j++) {
            for (int i = j + 1; i < nums1.length; i++) {
                if (nums1[i] < nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }

    /**
     * 双指针
     *
     * @param nums1 数组1
     * @param m     有效容量
     * @param nums2 数组2
     * @param n     有效容量
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int point1 = 0, point2 = 0;
        int index = 0;
        // 如果 指针1 没有遍历完 nums1 有效值，或 指针2 没有遍历完 num2 有效值
        while (point1 < m || point2 < n) {
            // 如果 指针1 遍历完，或者 nums1 中有效元素数为 0
            if (point1 == m) {
                sorted[index++] = nums2[point2++];
            }
            // 如果 指针2 遍历完，或者 nums2 中有效元素数为 0
            else if(point2 == n) {
                sorted[index++] = nums1[point1++];
            }
            // 如果 指针1 当前元素小于 指针2 当前元素
            else if (nums1[point1] < nums2[point2]) {
                sorted[index++] = nums1[point1++];
            }
            // 如果 指针1 当前元素大于等于 指针2 当前元素
            else {
                sorted[index++] = nums2[point2++];
            }
        }
        // 复制 sorted 中元素到 nums1 中
        System.arraycopy(sorted, 0, nums1, 0, m + n);
    }

    /**
     * 双指针尾部排序，根据题意可知 nums 1 大小正好容纳所有有效数，所以可以用 nums1 末尾开始插入
     *
     * @param nums1 数组1
     * @param m     有效容量
     * @param nums2 数组2
     * @param n     有效容量
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int point1 = m - 1, point2 = n - 1;
        int index = m + n - 1;
        // 如果 指针1 没有遍历完 nums1 有效值，或 指针2 没有遍历完 num2 有效值
        while (point1 >= 0 || point2 >= 0) {
            // 如果 指针1 遍历完，或者 nums1 中有效元素数为 0
            if (point1 == -1) {
                nums1[index--] = nums2[point2--];
            }
            // 如果 指针2 遍历完，或者 nums2 中有效元素数为 0
            else if(point2 == -1) {
                nums1[index--] = nums1[point1--];
            }
            // 如果 指针1 当前元素大于 指针2 当前元素
            else if (nums1[point1] > nums2[point2]) {
                nums1[index--] = nums1[point1--];
            }
            // 如果 指针1 当前元素小于等于 指针2 当前元素
            else {
                nums1[index--] = nums2[point2--];
            }
        }
    }
}
