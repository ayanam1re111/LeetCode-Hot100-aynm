package com.ayanami.leetcode.linkedlist;


public class _160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA;
        ListNode pb=headB;
        if(headA==null||headB==null){
            return null;
        }else{
            while(pa!=pb){
                pa=pa==null?headB:pa.next; //当pa已经走到底时，去headB
                pb=pb==null?headA:pb.next;
            }
            return pa;
            //若有公共节点，则会在pa和pb都走了a+b+c步后到达公共节点
            //若没有公共节点，会在pa和pb分别各自走完全部两个链表m+n后同时到达null
        }

    }
}
