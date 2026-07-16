class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        for (int i = 2; i <= x; i++) {
            long sq = (long) i * i; 
            if (sq == x) {
                return i;
            }
            if (sq > x) {
                return i - 1;
            }
        }
        return -1; 
    }
}
