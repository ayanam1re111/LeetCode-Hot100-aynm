package com.ayanami.leetcode.linkedlist;

public class _206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode p=head;
        //整体改变箭头方向
        while(p!=null){
            ListNode temp=p.next;
            p.next=prev;//每一轮循环都让p.next指向前一个
            prev=p;
            p=temp;//p向前走
        }
        return prev;

    }
}
