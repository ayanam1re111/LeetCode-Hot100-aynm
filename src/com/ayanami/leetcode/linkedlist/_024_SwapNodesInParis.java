package com.ayanami.leetcode.linkedlist;

public class _024_SwapNodesInParis {
    public ListNode swapPairs(ListNode head) {
    ListNode pre= new ListNode(0);
    pre.next=head;
    //临时结点
    ListNode temp=pre;
    while(temp.next!=null&& temp.next.next!=null){
        ListNode start =temp.next;
        ListNode end=temp.next.next;
        //主链是temp(0)
        temp.next=end;//拆成temp->end->end.next和start->end->end.next
        start.next=end.next;//temp->end->end.next和start->end.next
        end.next=start;
        temp=start;


    }
    return pre.next;
}
}
