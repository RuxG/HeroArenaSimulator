package com.Game;

import java.util.Objects;

public class MyPair<K, V> {
    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPair)) return false;
        MyPair<?, ?> myPair = (MyPair<?, ?>) o;
        return key.equals(myPair.key) &&
                value.equals(myPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
