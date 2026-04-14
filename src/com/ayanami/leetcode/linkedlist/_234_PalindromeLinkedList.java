package com.ayanami.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class _234_PalindromeLinkedList {
    ListNode front;
    List<Integer> a=new ArrayList<>();
    public boolean isPalindrome(ListNode head) { //前指针
        front=head;
        return recursCheck(head);


    }
    //迭代回溯
    public boolean recursCheck(ListNode curNode){
        if(curNode!=null){
            //走到链表末尾了，curNode.next=null，recursCheck(curNode.next)返回true,跳过这一次if，进入数字比较
            if(!recursCheck(curNode.next)){
                return false;
                //此次判断作用：
                //1.前面回溯检验全部无误的情况下推进下一次比较
                //2.前一次比较两数不相等，这一次直接返回false
            }
            // 回溯时比较当前节点与前指针节点
            if(curNode.val!=front.val){
                return false;
            }
            front=front.next;

        }
        return true;



    }

}
