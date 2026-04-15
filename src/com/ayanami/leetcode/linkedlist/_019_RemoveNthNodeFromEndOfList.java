package com.ayanami.leetcode.linkedlist;

public class _019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个虚拟头结点，防止原来的头节点被删导致找不到新链表的头结点
        ListNode prev=new ListNode(0);
        prev.next=head;
        //快指针
        ListNode fast=prev;
        //慢指针
        ListNode slow=prev;
        //快指针先走n步
        int i=0;
        while(i<n){
            fast=fast.next;
            i++;
        }
        //两个指针一起走，直到快指针走到最后
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //用慢指针删掉倒数第n个结点
        slow.next=slow.next.next;

        return prev.next;


    }

}
