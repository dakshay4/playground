package org.r7d.misc;


import java.util.List;

class PalindromeLinkList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode curr;
    public static boolean isPalindrome(ListNode head) {
         curr = head;
        return recursion(head);
    }
    public static boolean recursion(ListNode head) {
        if(head == null) return true;
        boolean res = recursion(head.next) && head.val == curr.val;
        curr=curr.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        System.out.println(isPalindrome(l));
//        ListNode list = reverseList(l);
        int size = sizeofList(l);
        reverseListInBatch(l,K, 1);
        printList(master);
        removeNodes(l2);
        if(nodeToRemove!=null) l2 = nodeToRemove.next;
        System.out.println();
        printList(l2);
    }

    static  int maxValue = Integer.MIN_VALUE;
    static ListNode nodeToRemove = null;
    public static void removeNodes(ListNode head) {
        if(head==null) return;
        removeNodes(head.next);
        if(nodeToRemove!=null) {head.next = nodeToRemove.next; nodeToRemove=null;}
        if(head.val<maxValue) nodeToRemove = head;
        maxValue = Math.max(maxValue, head.val);
    }

    private static int sizeofList(ListNode l) {
        int size = 0;
        while(l!=null) {
            size++;l=l.next;
        }
        return size;
    }

    static ListNode master = null;
    static ListNode prevHead = null;
    static int K = 3;


    private static void reverseListInBatch(ListNode head, int k, int batches) {
        if (head==null || batches<0) return;
        ListNode curHead = head;
        ListNode reverseHead = null;
        while(head!=null && k>0 && batches!=0){
            ListNode curNode = head;
            head=head.next;
            curNode.next = reverseHead;
            reverseHead = curNode;k--;
        }
        if(batches==0) reverseHead = curHead;
        if(master==null) master = reverseHead;
        if(prevHead!=null) prevHead.next = reverseHead;
        prevHead = curHead;
        reverseListInBatch(head, K, batches-1);
    }

    private static void printList(ListNode l) {
        while (l!=null) {
            System.out.print(l.val + " -> ");l=l.next;
        }
    }
// 1,2,3,4,5,6
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode curNode = head;
            head=head.next;
            curNode.next = prev;
            prev = curNode;
        }
        return prev;
    }


    public static ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        while(head!=null && k>0){
            ListNode curNode = head;
            head=head.next;
            curNode.next = prev;
            prev = curNode;k--;
        }
        return prev;
    }


}