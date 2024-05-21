package org.example.week7_midtermprep;
/*
quick sort
 */
import java.util.Random;

public class task10 {


    public class QuickSort {

        /* Quick sort algorithm (public invocation) */
        // your code
        public static void sort(int[] elements) {
            shuffle(elements);                                // shuffle the array
            sort(elements,0, elements.length-1);    // calling the sort function
        }

        /* Recursive quick sort logic */
        // your code
        private static void sort(int[] elements, int low, int high) {
            if(low>=high){
                return;             // array is sorted
            }

            int partitionIndex = partition(elements,low,high);      // partition the array

            sort(elements,low,partitionIndex-1);        // sort the left array
            sort(elements,partitionIndex+1,high);       // sort the right array
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
