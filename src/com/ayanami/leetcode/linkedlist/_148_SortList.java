package com.ayanami.leetcode.linkedlist;

public class _148_SortList {
    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        //让慢指针找到中间
        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //从中间截断
        ListNode temp=slow.next;
        slow.next=null;
        //迭代，直到左右各一个return head出第一层迭代
        ListNode left=sortList(head);
        ListNode right=sortList(temp);
        //设定头结点
        ListNode ans =new ListNode(0);
        //设定指针
        ListNode cur=ans;

        while(left!=null && right!=null){
            if(left.val<=right.val){
                cur.next=left;
                left=left.next;
            }else{
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }

        cur.next=left!=null ? left:right;

        return ans.next;

    }
}
