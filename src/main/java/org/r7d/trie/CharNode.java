package org.r7d.trie;

public class CharNode {

    private char c;
    private CharNode[] next;

    public CharNode(char c) {
        this.c = c;
        this.next = new CharNode[26];
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public CharNode[] getNext() {
        return next;
    }

    public void setNext(CharNode[] next) {
        this.next = next;
    }
}
