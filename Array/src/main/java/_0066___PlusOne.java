import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/8/10 14:27
 */
public class _0066___PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果当前位置为 9，则进行加一操作，赋值为 0
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // 如果不为 9，则直接加一
                // 如果上一次循环为 9，进行了加一操作，进位，加一操作完成，返回数组
                ++digits[i];
                return digits;
            }
        }
        // 如果循环遍历完，都为 9，则加一操作完，进位后，还有在最前面补一位 1，后面都是 0
        // 所以创建数组，默认数组中所有值为 0，但是由于进位，所以 ans[0] 为 1
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
