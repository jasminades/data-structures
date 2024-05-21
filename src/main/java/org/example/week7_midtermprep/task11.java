package org.example.week7_midtermprep;

import java.util.Random;

/*
quick sort algorithm for integer data in descending order
- modify partition
 */
public class task11 {

    public class QuickSort {

        /* Quick sort algorithm (public invocation) */
        // your code
        public static void sort(int[] elements) {
            shuffle(elements);
            sort(elements,0, elements.length-1);
        }

        /* Recursive quick sort logic */
        // your code
        private static void sort(int[] elements, int low, int high) {
            if(low>=high){
                return;                 // array is sorted
            }

            int partitionIndex = partition(elements,low,high);

            sort(elements,low,partitionIndex-1);        // sort the left side
            sort(elements,partitionIndex+1,high);       // sort the right side
        }

        private static void shuffle(int[] elements) {
            Random rand = new Random();
            for (int i = 0; i < elements.length; i++) {
                int r = i + rand.nextInt(elements.length - i);

                int tmp = elements[r];
                elements[r] = elements[i];
                elements[i] = tmp;
            }
        }

        private static int partition(int[] elements, int low, int high) {
            int i = low;
            int j = high + 1;
            while (true) {
                // previous: while (less(elements[++i], elements[low])) {
                while(less(elements[low], elements[++i])){
                    if (i == high) {
                        break;
                    }
                }
                // previous: while (less(elements[low], elements[--j])) {
                while(less(elements[--j], elements[low])){
                    if (j == low) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                swap(elements, i, j);
            }
            swap(elements, low, j);
            return j;
        }

        /**
         * Helper methods.
         * No need to modify these two methods.
         */

        /* Returns whether the first element is less than the second one */
        public static boolean less(int v, int w) {
            return v < w;
        }

        /* Swaps the two elements in an array */
        public static void swap (int[] elements, int a, int b) {
            int tmp = elements[a];
            elements[a] = elements[b];
            elements[b] = tmp;
        }
    }
}
