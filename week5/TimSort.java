package org.example.week5;

public class TimSort {
    public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {
        // Create an auxiliary array for merging
        Comparable[] aux = new Comparable[elements.length];

        // Perform Timsort
        timsort(elements, aux, threshold);
    }

    private static <Data extends Comparable<Data>> void timsort(Data[] elements, Comparable[] aux, int threshold) {
        int n = elements.length;

        // Calculate the minimum run length
        int minRun = calculateMinRun(n, threshold);

        // Divide the array into runs and sort each run using insertion sort
        for (int i = 0; i < n; i += minRun) {
            int runEnd = Math.min(i + minRun - 1, n - 1);
            insertionSort(elements, i, runEnd);
        }

        // Merge adjacent runs
        for (int size = minRun; size < n; size *= 2) {
            for (int start = 0; start < n; start += 2 * size) {
                int mid = Math.min(start + size - 1, n - 1);
                int end = Math.min(start + 2 * size - 1, n - 1);
                merge(elements, aux, start, mid, end);
            }
        }
    }

    private static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Data key = elements[i];
            int j = i - 1;
            while (j >= low && elements[j].compareTo(key) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }

    private static <Data extends Comparable<Data>> void merge(Data[] elements, Comparable[] aux, int low, int mid, int high) {
        // Copy elements to auxiliary array
        for (int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        // Merge the two sorted subarrays
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = (Data) aux[j++];
            } else if (j > high) {
                elements[k] = (Data) aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                elements[k] = (Data) aux[j++];
            } else {
                elements[k] = (Data) aux[i++];
            }
        }
    }

    public static int calculateMinRun(int n, int threshold) {
        int r = 0;
        while (n >= threshold) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static int calculateRunLength(int initialLength, int threshold) {
        // Calculate the run length using the given threshold
        return Math.min(initialLength, threshold);
    }
}
