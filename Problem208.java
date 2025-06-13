public class Problem208 {
    public static void main(String[] args) {
        Solution trie = new Solution();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }
}

class Solution {
    private Solution[] children;
    private boolean isEnd;

    public Solution() {
        children = new Solution[26];
    }

    public void insert(String word) {
        Solution node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Solution();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Solution node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Solution node = searchPrefix(prefix);
        return node != null;
    }

    private Solution searchPrefix(String s) {
        Solution node = this;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}