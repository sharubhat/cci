package hackerrank.arrays_strings_and_everything.cci.tries;

import java.util.List;

/**
 * Created by sharath on 6/4/16.
 */
public class Trie {
    private TrieNode root;

    public Trie(List<String> words) {
        this.root = new TrieNode();
        for(String w : words) {
            root.addWord(w);
        }
    }

    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for(int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if(lastNode == null)
                return false;
        }
        return !exact || lastNode.terminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }
}
