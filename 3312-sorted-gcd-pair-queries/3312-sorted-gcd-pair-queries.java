import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }
        long[] exactGcd = new long[max + 1];
        for (int g = max; g >= 1; g--) {
            long count = 0;
            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
            }
            exactGcd[g] = count * (count - 1) / 2;
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                exactGcd[g] -= exactGcd[multiple];
            }
        }
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exactGcd[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i] + 1;
            int left = 1;
            int right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= q)
                    right = mid;
                else
                    left = mid + 1;
            }
            ans[i] = left;
        }
        return ans;
    }
}