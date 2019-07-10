package com.renho.solution;

import org.junit.Test;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P208 {

    @Test
    public void test() {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));    // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 true
    }

    class Trie {

        class TrieNode {
            private TrieNode[] child = new TrieNode[26];
            private char val;
            private boolean isFinish = false;
            public TrieNode() {
            }
            public TrieNode(char val) {
                this.val = val;
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode processChild = this.root;
            for(int i=0; i<word.length(); i++) {
                if(null == processChild.child[word.charAt(i) - 'a']) {
                    processChild.child[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
                }
                processChild = processChild.child[word.charAt(i) - 'a'];
            }
            processChild.isFinish = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode processChild = this.root;
            for(int i=0; i<word.length(); i++) {
                if(null == processChild.child[word.charAt(i) - 'a']) {
                    return false;
                }
                processChild = processChild.child[word.charAt(i) - 'a'];
            }
            return processChild.isFinish;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode processChild = this.root;
            for(int i=0; i<prefix.length(); i++) {
                if(null == processChild.child[prefix.charAt(i) - 'a']) {
                    return false;
                }
                processChild = processChild.child[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

}
