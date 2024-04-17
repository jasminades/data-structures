package org.example.week7_midtermprep;


/*
quick sort algorithm
- implement public and private sort()

 */
import java.util.Random;


public class task20 {

    public class QuickSort {

        /* Quick sort algorithm (public invocation) */
        public static void sort(int[] elements) {
            shuffle(elements);
            sort(elements,0,elements.length-1);

        }

        /* Recursive quick sort logic */
        private static void sort(int[] elements, int low, int high) {
            // your code
            if(low>=high){
                return;
            }

            int parititonIndex = partition(elements,low,high);

            sort(elements,low,parititonIndex-1);
            sort(elements,parititonIndex+1, high);
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
                while (less(elements[++i], elements[low])) {
                    if (i == high) {
                        break;
                    }
                }
                while (less(elements[low], elements[--j])) {
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
