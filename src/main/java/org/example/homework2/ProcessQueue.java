package org.example.homework2;

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    public ProcessQueue(int capacity) {
        pq = new Process[capacity];
    }

    /* Add a new process into the priority queue */
    public void addProcess(Process process) {
        if (length == pq.length) {
            resize();
        }
        pq[length] = process;
        heapifyUp(length);
        length++;
    }

    /* Return and remove the next Process that should be run */
    public Process runNextProcess() {
        if (length == 0) {
            return null;
        }
        Process nextProcess = pq[0];
        pq[0] = pq[length - 1];
        length--;
        heapifyDown(0);
        return nextProcess;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if (length == 0) {
            return null;
        }
        return pq[0];
    }

    private void resize() {
        Process[] newPq = new Process[pq.length * 2];
        System.arraycopy(pq, 0, newPq, 0, pq.length);
        pq = newPq;
    }

    private void heapifyUp(int index) {
        while (index > 0 && pq[(index - 1) / 2].compareTo(pq[index]) > 0) {
            swap((index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        while (index * 2 + 1 < length) {
            int smallestChild = index * 2 + 1;
            if (index * 2 + 2 < length && pq[index * 2 + 2].compareTo(pq[smallestChild]) < 0) {
                smallestChild = index * 2 + 2;
            }
            if (pq[index].compareTo(pq[smallestChild]) <= 0) {
                break;
            }
            swap(index, smallestChild);
            index = smallestChild;
        }
    }

    private void swap(int index1, int index2) {
        Process temp = pq[index1];
        pq[index1] = pq[index2];
        pq[index2] = temp;
    }
}
