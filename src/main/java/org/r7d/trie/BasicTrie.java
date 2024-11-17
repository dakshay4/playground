package org.r7d.trie;

public class BasicTrie {

    private CharNode[] root = new CharNode[26];

    public void ingest(String s) {
        CharNode[] temp = root;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int pos = c -97;
            System.out.println("char c " + c + " pos " + pos);
            CharNode node = temp[pos];
            CharNode newNode = new CharNode(c);
            if(node == null ) node = newNode;
            temp[pos] = node;
            temp = node.getNext();
        }
    }


    private void print() {
        printLevel(root);
    }
    private void printLevel(CharNode[] charNode) {
        if(charNode == null) return;
        System.out.println();
        for(int i=0;i<26;i++) {
            CharNode node =  charNode[i];
            if(node == null) continue;
            System.out.print(node.getC() + ", ");
            printLevel(node.getNext());
        }
    }

    public boolean search(String s) {
        CharNode[] temp = root;
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            int pos = c -97;
            CharNode node = temp[pos];
            if(node!=null) temp = node.getNext();
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BasicTrie basicTrie = new BasicTrie();
        basicTrie.ingest("cats");
        basicTrie.ingest("cat");
        basicTrie.ingest("dogs");
        basicTrie.ingest("doll");
        basicTrie.print();
        boolean found = basicTrie.search("dog");
        System.out.println("Is String found {}" + found);
    }

}

/*
[c,   d,h]
[d][t]

 */