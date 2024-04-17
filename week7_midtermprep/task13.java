package org.example.week7_midtermprep;
/*
merge sort algorithm
 */
public class task13 {
    public class MergeSort {

        /* Merge sort algorithm (public invocation) */
        // your code
        public static void sort(int[] elements) {
            int[] aux= new int[elements.length];
            sort(elements,aux,0,elements.length-1);
        }

        /* Recursive merge sort logic */
        // your code
        private static void sort(int[] elements, int[] aux, int low, int high) {
            if(low>=high){
                return;
            }

            int mid=low + (high-low) / 2;

            sort(elements,aux,low,mid);
            sort(elements,aux,mid+1,high);merge(elements,aux,low,mid,high);
        }/* Merge the two sorted sub-arrays into a larger sorted (sub)array */
        private static void merge(int[] elements, int[] aux, int low, int mid, int high) {

            for (int k = low; k <= high; k++) {
                aux[k] = elements[k];
            }

            int i = low;
            int j = mid + 1;
            for (int k = low; k <= high; k++) {
                if (i > mid) {
                    elements[k] = aux[j++];
                } else if (j > high) {
                    elements[k] = aux[i++];
                } else if (less(aux[j], aux[i])) {
                    elements[k] = aux[j++];
                } else {
                    elements[k] = aux[i++];
                }
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



