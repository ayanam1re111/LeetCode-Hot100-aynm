package com.ayanami.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode ans =head;
        Set<ListNode> a= new HashSet<>();
        while(ans!=null){
            if(a.contains(ans)){
                return ans;

            }else{
                a.add(ans);
                ans=ans.next;
            }
        }
        return null;

    }
}
