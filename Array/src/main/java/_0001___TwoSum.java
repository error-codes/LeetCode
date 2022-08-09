import java.util.HashMap;
import java.util.Map;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/8/9 16:35
 */
public class _0001___TwoSum {

    /**
     * 暴力解法
     *
     * @param nums   数组
     * @param target 目标数
     * @return 元素下标
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 如果两数之和等于目标数，返回其下标位置
                if (target == (nums[i] + nums[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hash表
     *
     * @param nums   数组
     * @param target 目标数
     * @return 元素下标
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果 Map 包含当前目标数减去当前元素的差值
            if (numIndex.containsKey(target - nums[i])) {
                // 返回元素下标位置
                return new int[]{i, numIndex.get(target - nums[i])};
            }
            // 不包含则添加元素至 Map 中
            numIndex.put(nums[i], i);
        }
        return null;
    }
}
