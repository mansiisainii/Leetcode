class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] finish = new long[n];
        for (int j = 0; j < m; j++) {
            long prefix = 0;
            long start = 0;
            for (int i = 0; i < n; i++) {
                start = Math.max(start, finish[i] - prefix);
                prefix += 1L * skill[i] * mana[j];
            }
            long cur = start;
            for (int i = 0; i < n; i++) {
                cur += 1L * skill[i] * mana[j];
                finish[i] = cur;
            }
        }
        return finish[n - 1];
    }
}