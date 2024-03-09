package org.example.week1;

public class DoubleNode<Data> {
    private Data data;
    private DoubleNode<Data> prev;
    private DoubleNode<Data> next;

    public DoubleNode(Data data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Data getData() {
        return data;
    }

    public DoubleNode<Data> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<Data> prev) {
        this.prev = prev;
    }

    public DoubleNode<Data> getNext() {
        return next;
    }

    public void setNext(DoubleNode<Data> next) {
        this.next = next;
    }
}

