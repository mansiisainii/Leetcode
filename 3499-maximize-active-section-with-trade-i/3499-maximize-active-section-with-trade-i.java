class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        String t = "1" + s + "1";
        List<Integer> runs = new ArrayList<>();
        List<Character> type = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i) == t.charAt(i - 1)) {
                cnt++;
            } else {
                type.add(t.charAt(i - 1));
                runs.add(cnt);
                cnt = 1;
            }
        }

        type.add(t.charAt(t.length() - 1));
        runs.add(cnt);
        int ans = ones;
        for (int i = 1; i < runs.size() - 1; i++) {
            if (type.get(i) == '1'
                    && type.get(i - 1) == '0'
                    && type.get(i + 1) == '0') {

                ans = Math.max(ans,
                        ones + runs.get(i - 1) + runs.get(i + 1));
            }
        }
        return ans;
    }
}