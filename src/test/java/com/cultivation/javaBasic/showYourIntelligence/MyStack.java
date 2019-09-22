package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class MyStack {
    private int[] storage;
    private int capacity;
    private int count;
    private static final int GROW_FACTOR = 2;

    public MyStack(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Capacity too small.");
        }

        capacity = initialCapacity;
        storage = new int[initialCapacity];
        count = 0;
    }

    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }

        // TODO: Please push the value into the storage here.
        // <--start
        this.storage[count++] = value;
        return;
        // --end-->
    }

    private void ensureCapacity() {
        int newCap = this.capacity * this.GROW_FACTOR;

        // TODO: Please create a new array of size newCapacity. And update related fields
        // TODO: You SHOULD NOT USE COLLECTIONS OTHER THAN ARRAY.
        // <--start
        int[] newStorageCap = new int[newCap];
        for (int x = 0; x < storage.length; x++){
            newStorageCap[x] = storage[x];
        }
        this.storage = newStorageCap;
        this.capacity = newCap;
        // --end-->
    }

    public int[] popToArray() {
        final int totalItemsCount = count;
        int[] popArray = new int[totalItemsCount];

        while (count > 0) {
            popArray[totalItemsCount - count] = pop();
        }

        return popArray;
    }

    private int pop() {
        // TODO: Please pop one element from the array.
        // <--start
        if (count >= 0){
            return storage[--count];
        }
        // --end-->

        throw new UnsupportedOperationException("Stack is empty.");
    }
}
