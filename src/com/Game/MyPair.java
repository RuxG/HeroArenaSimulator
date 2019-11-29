package com.Game;

import java.util.Objects;

/**
 * This class simulates the functionalities of "java.util.Pair"
 */
public class MyPair<K, V> {
    private K key;
    private V value;

    public MyPair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final void put(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public final String toString() {
        return "MyPair{"
                + "key=" + key
                + ", value=" + value
                + '}';
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MyPair)) {
            return false;
        }
        MyPair<?, ?> myPair = (MyPair<?, ?>) o;
        return this.key.equals(myPair.key)
                && this.value.equals(myPair.value);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.key, this.value);
    }
}
