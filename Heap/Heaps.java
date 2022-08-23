package Heap;

import java.util.PriorityQueue;

public class Heaps {
    int cap, sz;
    int[] arr;

    Heaps(int capacity) {
        cap = capacity;
        sz = 0;
        arr = new int[cap];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }

    int left (int i) {
        return (2 * i) + 1;
    }

    int right (int i) {
        return (2 * i) + 2;
    }

    int parent (int i) {
        return (i -1) / 2;
    }

    // insert in the heap
    void insert (int key) {
        if (sz == cap) return;
        sz++; arr[sz-1] = key;

        for (int i = sz-1; i != 0 && arr[parent(i)] > arr[i];) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;

            i = parent(i);
        }
    }

    // get the min value
    int getMin() {
        return arr[0];
    }

    // delete the minimum value
    int extractMin() {
        if (sz <= 0) return Integer.MAX_VALUE;
        if (sz == 1) {
            sz--;
            return arr[0];
        }

        int temp = arr[0];
        arr[0] = arr[sz-1];
        arr[sz-1] = temp;
        sz--;
        minHeap(0);

        return arr[sz];
    }

    // fix the minimum heap
    void minHeap(int i) {
        int leftIndex = left(i);
        int rightIndex = right(i);

        int smallest = i;

        if (leftIndex < sz && arr[leftIndex] < arr[smallest]) {
            smallest = leftIndex;
        }

        if (rightIndex < sz && arr[rightIndex] < arr[smallest]) {
            smallest = rightIndex;
        }

        if (smallest != i){
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = smallest;
            minHeap(smallest);
        }

    }

    // decrease a value and adjust it
    void decreaseKey (int i, int data) {
        arr[i] = data;

        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;

            i = parent(i);
        }
    }

    // delete a key
    void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // build heap
    void buildHeap() {
        for (int i=(sz-2)/2; i>=0; i--){
            minHeap(i);
        }
    }
}
