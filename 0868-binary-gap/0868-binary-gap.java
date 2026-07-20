class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int index = 0;
        int ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (prev != -1) {
                    ans = Math.max(ans, index - prev);
                }
                prev = index;
            }
            n >>= 1;
            index++;
        }
        return ans;
    }
}