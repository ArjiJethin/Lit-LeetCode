import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Problem472 {
    public static void main(String[] args) {
        // Example usage
        String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        Solution solution = new Solution();
        List<String> result = solution.findAllConcatenatedWordsInADict(words);
        System.out.println("Concatenated words: " + result); // Expected output:
                                                             // ["catsdogcats","dogcatsdog","ratcatdogcat"]
    }
}

class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd;

    void insert(String w) {
        Trie node = this;
        for (char c : w.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }
}

class Solution {
    private Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (dfs(w)) {
                ans.add(w);
            } else {
                trie.insert(w);
            }
        }
        return ans;
    }

    private boolean dfs(String w) {
        if ("".equals(w)) {
            return true;
        }
        Trie node = trie;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd && dfs(w.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}