package alg.trees;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 *     Trie() Initializes the trie object.
 *     void insert(String word) Inserts the string word into the trie.
 *     boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 *     boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 *
 * Constraints:
 *
 *     1 <= word.length, prefix.length <= 2000
 *     word and prefix consist only of lowercase English letters.
 *     At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app"));      // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }

    private static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                int idx = ch - 'a';
                if (node.getChildren()[idx] == null) {
                    node.getChildren()[idx] = new TrieNode();
                }
                node = node.getChildren()[idx];
            }
            node.setWord(true);
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                int idx = ch - 'a';
                if (node == null || node.getChildren()[idx] == null) {
                    return false;
                }
                node = node.getChildren()[idx];
            }
            return node.isWord();
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch: prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node == null || node.getChildren()[idx] == null) {
                    return false;
                }
                node = node.getChildren()[idx];
            }
            return true;
        }
    }

    private static class TrieNode {
        boolean word;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public TrieNode[] getChildren() {
            return children;
        }
    }
}
