package org.example.week6;

import java.util.Random;

public class DualPivotQuickSort {
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }

    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        Random rand = new Random();
        for (int i = elements.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(elements, i, j);
        }
    }


    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        if (low < high) {
            int[] pivots = partition(elements, low, high);
            sort(elements, low, pivots[0] - 1);
            sort(elements, pivots[0] + 1, pivots[1] - 1);
            sort(elements, pivots[1] + 1, high);
        }
    }

    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        int leftPivot = low;
        int rightPivot = high;

        if (elements[leftPivot].compareTo(elements[rightPivot]) > 0) {
            swap(elements, leftPivot, rightPivot);
        }

        int i = leftPivot + 1;
        int j = rightPivot - 1;
        int k = i;

        while (k <= j) {
            if (elements[k].compareTo(elements[leftPivot]) < 0) {
                swap(elements, k, i);
                i++;
                k++;
            } else if (elements[k].compareTo(elements[rightPivot]) > 0) {
                swap(elements, k, j);
                j--;
            } else {
                k++;
            }
        }

        swap(elements, leftPivot, i - 1);
        swap(elements, rightPivot, j + 1);

        return new int[]{i - 1, j + 1};
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}
