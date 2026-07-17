class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits)
            freq[d]++;
        List<Integer> list = new ArrayList<>();
        for (int num = 100; num <= 998; num += 2) {
            int[] need = new int[10];
            int x = num;
            need[x % 10]++;
            x /= 10;
            need[x % 10]++;
            x /= 10;
            need[x % 10]++;

            boolean possible = true;
            for (int i = 0; i < 10; i++) {
                if (need[i] > freq[i]) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                list.add(num);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}