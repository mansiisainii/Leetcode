class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int high = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > high) high = piles[i];
        }

        int ans = high;
        while (l <= high) {
            int mid = l + (high - l) / 2;
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }
            if (hours <= h) {
                ans = mid;
                high = mid - 1;   // ✅ yahan correction
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}