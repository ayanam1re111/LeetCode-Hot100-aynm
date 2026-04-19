package com.ayanami.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _146_LruCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        //空结点，用来创造头尾的伪结点
        public DLinkedNode(){}
        //用来创造真正的结点
        public DLinkedNode(int _key,int _value){
            key= _key;
            value= _value;
        }
    }
    //创建哈希表存储key和节点，用于判断节点是否已存在
    private Map<Integer,DLinkedNode> cache=new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public _146_LruCache(int capacity) {
        this.size=0;//当前大小
        this.capacity=capacity;//最大容量
        //尾节点
        head=new DLinkedNode();
        tail=new DLinkedNode();
        //头尾相连形成初始双向链表
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        DLinkedNode node=cache.get(key);
        if(node==null){
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value) {
        DLinkedNode node=cache.get(key);
        if(node == null){
            //如果key不存在，创建一个新的节点
            DLinkedNode newNode= new DLinkedNode(key,value);
            //添加进哈希表
            cache.put(key,newNode);
            //添加到双向链表的头部
            addToHead(newNode);
            ++size;
            if(size>capacity){
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail=removeTail();//tail接收返回的已从链表删除节点，用于cache中删除
                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else{
            //如果key存在，先通过哈希表定位，再修改value，并移到头部
            node.value=value;
            moveToHead(node);
        }

    }

    private void addToHead(DLinkedNode node){
        //将node接入双向链表
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(DLinkedNode node){
        //跳过node
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
}
