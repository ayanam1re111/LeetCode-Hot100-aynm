package com.ayanami.leetcode.linkedlist;



import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node,Node> map=new HashMap<>();
        //头结点不会改变时，直接=head即可
        Node cur=head;

        //遍历，把每个val值填好
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        //遍历，通过键get出值，将next和random填上
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        cur=head;
        return map.get(cur);

    }
}
