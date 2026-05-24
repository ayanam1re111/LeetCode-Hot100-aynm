package com.ayanami.leetcode.graphtheory;

public class _208_ImplementTrie {
    //定义节点
    public class Node{
        Node[] son=new Node[26];//定义子节点
        boolean end=false;//Node自带属性，end标记：默认为false，只有在Insert时候会把单词的尾结点改为end
    }
    private final Node root=new Node();//定义全局唯一根节点

    public _208_ImplementTrie() {

    }

    public void insert(String word) {
        Node cur=root;//地址赋值，共用全局同一棵树
        for(char c:word.toCharArray()){
            c-='a';//算该走哪个子节点处,【这个写法自带类型强转，但是c=c-'a'会报错】
            if(cur.son[c]==null){
                cur.son[c]=new Node();
            }
            cur=cur.son[c];//移动
        }
        cur.end=true;

    }

    public boolean search(String word) {
        return find(word)==2;

    }

    public boolean startsWith(String prefix) {
        return find(prefix)!=0;

    }

    private int find(String word){
        Node cur=root;
        for(char c:word.toCharArray()){
            c-='a';
            if(cur.son[c]==null){
                //没有，直接返回0
                return 0;
            }
            cur=cur.son[c];
        }
        //2：完全查找到完整单词 1:查找到前缀存在
        return cur.end ? 2:1;
    }
}
