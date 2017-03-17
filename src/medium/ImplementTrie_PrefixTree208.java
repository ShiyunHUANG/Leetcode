package medium;

public class ImplementTrie_PrefixTree208 {
    /** Initialize your data structure here. */
    private TrieNode root;
    public ImplementTrie_PrefixTree208() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode node = root;
        for(char ch : arr) {
            if(node.get(ch) == null) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch); //not else! must do this
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode node = root;
        for(char ch : arr) {
            if(node.get(ch) == null) {
                return false;
            }
            node = node.get(ch);
        }
        return node.checkIfEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode node = root;
        for(char ch : arr) {
            if(node.get(ch) == null) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}
class TrieNode {
    private boolean isEnd;
    private TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false; //default
    }
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean checkIfEnd() {
        return isEnd;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
