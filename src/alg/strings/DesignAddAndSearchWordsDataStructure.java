package alg.strings;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 *     WordDictionary() Initializes the object.
 *     void addWord(word) Adds word to the data structure, it can be matched later.
 *     bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 *     word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 *     1 <= word.length <= 25
 *     word in addWord consists of lowercase English letters.
 *     word in search consist of '.' or lowercase English letters.
 *     There will be at most 3 dots in word for search queries.
 *     At most 104 calls will be made to addWord and search.
 */

// NOT checked!
public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
         WordDictionary obj = new WordDictionary();

         String word = "abcd";
         obj.addWord(word);
         boolean param_2 = obj.search("a.c.");
    }

    private static class WordDictionary {
        TreeNode root;

        public WordDictionary() {
            root = new TreeNode();
        }

        public void addWord(String word) {
            TreeNode temp = root;
            for (char ch: word.toCharArray()) {
                int idx = ch - 'a';
                TreeNode child = temp.getChildren()[idx];
                if (child == null) {
                    child = new TreeNode();
                    temp.getChildren()[idx] = child;
                    temp = child;
                }
            }
        }

        public boolean search(String word) {
            return search(word, root);
        }

        private static boolean search(String word, TreeNode node) {
            TreeNode temp = node;
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                char ch = chars[i];
                if (ch == '.') {
                    for (TreeNode tempNode: temp.getChildren()) {
                        if (tempNode != null && search(word.substring(i + 1), tempNode)) {
                            return true;
                        }
                    }
                } else {
                    temp = temp.getChildren()[ch - 'a'];
                    if (temp == null) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class TreeNode {
        private TreeNode[] children = new TreeNode[26];

        public TreeNode() {
        }

        public TreeNode[] getChildren() {
            return children;
        }
    }
}
