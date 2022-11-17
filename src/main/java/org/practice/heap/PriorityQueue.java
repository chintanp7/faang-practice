package org.practice.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {

    private List<T> _heap;
    private Comparator<T> _comparator;

    public PriorityQueue(Comparator<T> comparator) {
        this._heap = new ArrayList<>();
        this._comparator = comparator;
    }

    public PriorityQueue() {
        this._heap = new ArrayList<>();
        this._comparator = (Comparator.comparingInt(o -> ((int) o)));
    }

    public int size() {
        return _heap.size();
    }

    public boolean isEmpty() {
        return _heap.isEmpty();
    }

    public T peek() {
        return _heap.get(0);
    }

    private int _parent(int index) {
        return (int) Math.floor((index - 1) / 2.0);
    }

    private int _left(int index) {
        return (index * 2) + 1;
    }

    private int _right(int index) {
        return (index * 2) + 2;
    }

    private void _swap(int from, int to) {
        Collections.swap(_heap, from, to);
    }

    public int push(T element) {
        this._heap.add(element);
        this._siftUp();
        return this.size();
    }

    private boolean _compare(int i, int j) {
        return this._comparator.compare(_heap.get(i), _heap.get(j)) > 0;
    }

    private void _siftUp() {
        int nodeIndex = this._heap.size() - 1;
        while (nodeIndex > 0 && this._compare(nodeIndex, _parent(nodeIndex))) {
            _swap(nodeIndex, _parent(nodeIndex));
            nodeIndex = _parent(nodeIndex);
        }
    }

    private void _siftDown() {
        int nodeIndex = 0;

        while ((this._left(nodeIndex) < _heap.size() && this._compare(this._left(nodeIndex), nodeIndex)) || (this._right(nodeIndex) < _heap.size() && this._compare(this._right(nodeIndex), nodeIndex))) {
            int greaterIndex = this._right(nodeIndex) < this.size() && this._compare(this._right(nodeIndex), this._left(nodeIndex)) ? this._right(nodeIndex) : this._left(nodeIndex);
            this._swap(nodeIndex, greaterIndex);
            nodeIndex = greaterIndex;
        }
    }

    public T pop() {
        this._swap(0, this.size() - 1);
        T returnElement = _heap.remove(this.size() - 1);
        this._siftDown();
        return returnElement;
    }
}
