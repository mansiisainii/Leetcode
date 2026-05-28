class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int index = -1;
    }
    TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
    public void insert(String word, int idx, String[] wordsContainer) {
        TrieNode node = root;
        if (node.index == -1 ||
            wordsContainer[idx].length() <
            wordsContainer[node.index].length()) {
            node.index = idx;
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }
            node = node.child[ch];
            if (node.index == -1 ||
                wordsContainer[idx].length() <
                wordsContainer[node.index].length()) {
                node.index = idx;
            }
        }
    }
    public int search(String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (node.child[ch] == null) {
                break;
            }
            node = node.child[ch];
        }
        return node.index;
    }
}