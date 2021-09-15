package com.tuling;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/15 16:49
 */
public class HashMap<K, V> {

    private Object[] containers = new Object[10];

    public void put(K key, V value) {
        //获取key的hashcode
        int hashcode = key.hashCode();
        //获取数组的索引
        int _index = hashcode % containers.length;
        Node<K, V> next = (Node<K, V>) containers[_index];
        Node<K, V> node = new Node<K,V>(key, value, next);
        System.out.println(_index);


    }

    public V get(K key) {
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> maps = new HashMap<>();
        maps.put("1", "2");
        maps.put("2", "2");
        maps.put("3", "2");
        maps.put("4", "2");
        maps.put("我爱北京天安门", "2");
        maps.put("你好", "2");
    }


}
