class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int bestIdx = -1;
    }

    TrieNode root = new TrieNode();
    String[] words;

    private boolean isBetter(int newIdx, int oldIdx) {
        if (oldIdx == -1) return true;

        int len1 = words[newIdx].length();
        int len2 = words[oldIdx].length();

        if (len1 != len2) {
            return len1 < len2;
        }

        return newIdx < oldIdx;
    }

    private void insert(String word, int idx) {
        TrieNode node = root;

        if (isBetter(idx, node.bestIdx)) {
            node.bestIdx = idx;
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            if (isBetter(idx, node.bestIdx)) {
                node.bestIdx = idx;
            }
        }
    }

    private int search(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                break;
            }

            node = node.child[ch];
        }

        return node.bestIdx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        words = wordsContainer;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}