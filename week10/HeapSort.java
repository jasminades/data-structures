package org.example.week10;

public class HeapSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        int n = elements.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(elements, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(elements, 0, i);

            heapify(elements, i, 0);
        }
    }

    private static <Data extends Comparable<Data>> void heapify(Data[] elements, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && elements[left].compareTo(elements[largest]) > 0) {
            largest = left;
        }

        if (right < heapSize && elements[right].compareTo(elements[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(elements, i, largest);

            heapify(elements, heapSize, largest);
        }
    }

    private static <Data> void swap(Data[] elements, int i, int j) {
        Data temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}