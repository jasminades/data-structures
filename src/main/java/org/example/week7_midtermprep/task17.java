package org.example.week7_midtermprep;

/*
 insertion sort algorithm for integer data by filling in the missing code in the sort() method.
 */
public class task17 {

    public class InsertionSort {

        /* Insertion sort algorithm */
        public static void sort(int[] elements) {
            // your code
            int n=elements.length;
            for(int i=1; i<n; i++){
                int key = elements[i];
                int j=i-1;

                while(j>=0 && less(key,elements[j])){
                    elements[j+1] = elements[j];
                    j=j-1;
                }
                elements[j+1]=key;
            }
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
