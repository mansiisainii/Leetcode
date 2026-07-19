class Solution {
    StringBuilder ans = new StringBuilder();
    Set<String> visited = new HashSet<>();
    public String crackSafe(int n, int k) {
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            start.append('0');
        }
        dfs(start.toString(), k);
        ans.append(start);
        return ans.toString();
    }
    private void dfs(String node, int k) {
        for (int i = 0; i < k; i++) {
            String edge = node + i;
            if (!visited.contains(edge)) {
              visited.add(edge);
                dfs(edge.substring(1), k);
                ans.append(i);
            }
        }
    }
}