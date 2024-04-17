package org.example.week7_midtermprep;

// insertion sort

public class task6 {
    public class InsertionSort {

        /* Insertion sort algorithm (reverse sorting) */
        // your code here
        public static void sort(int[] elements) {
            for(int i=1; i<elements.length; i++){

                // j is initialized with value of i, the loop continues until j > 0
                // checking if element at j is bigger than 0 AND element at index j-1 is less than index at j

                for(int j=i; i>0 && less(elements[j-1], elements[j]); j--){
                    swap(elements, j ,j-1);                                      // if element at j-1 is less than element at index j, we swap them
                }
            }
        }

        /**
         * Helper methods.
         * You may modify them if necessary, or implement your own alternatives.
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
