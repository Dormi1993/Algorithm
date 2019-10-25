package com.fcj.test.test1.hashmap;


import java.util.HashMap;

/**
 * Created by dormi on 2017/10/1.
 */
public class Hashmap<K, V> {

    private static int DEFULT = 16;
    private Node<K, V>[] buckets;


    public Hashmap(){
    }

    public void put(K key, V value) {
        if (key == null){
            throw new IllegalArgumentException("cuole");
        }

        int position = hash(key);

        Node<K, V> node = buckets[position];

        while (node != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<K, V>(key, value);

        if (buckets[position] != null){
            newNode.setNext(buckets[position]);
        }

        buckets[position] = newNode;

    }

    public V get(K key){
        if (key == null){
            throw new IllegalArgumentException("cuole");
        }

        int position = hash(key);

        Node<K, V> node = buckets[position];

        while (node != null){
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    public int hash(K key){
        return key.hashCode();
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
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
    }
}

