package com.tuling;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/15 17:23
 */
public class Node<K, V> {

    private  K key;
    private  V value;
    private  Node<K,V> next;
    private int hash;

    public Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = key.hashCode();
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
