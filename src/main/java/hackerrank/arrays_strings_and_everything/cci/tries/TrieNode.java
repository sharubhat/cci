package hackerrank.arrays_strings_and_everything.cci.tries;

import java.util.HashMap;

/**
 * Created by sharath on 6/4/16.
 */
class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean terminates = false;
    private char character;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode(char c) {
        this();
        this.character = c;
    }

    public char getChar() {
        return this.character;
    }

    // add word to trie and recursively create child nodes.
    public void addWord(String word) {
        if(word == null || word.isEmpty())
            return;
        char firstChar = word.charAt(0);

        TrieNode child = getChild(firstChar);
        if(child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if(word.length() > 1) {
            child.addWord(word.substring(1));
        }
        else {
            child.setTerminates(true);
        }
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public boolean terminates() {
        return terminates;
    }

    public void setTerminates(boolean b) {
        this.terminates = b;
    }

}