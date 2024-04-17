package org.example.week7_midtermprep;
/*
selection sort
 */
public class task9 {
    public class SelectionSort {

        /* Selection sort algorithm (reverse sorting) */
        // your code
        public static void sort(int[] elements) {
            int n= elements.length;
            for(int i=0; i<n-1;i++){                        // iterates over each element of the array except the last one
                int maxIndex=i;                             // initializing the maximum element
                for(int j=i+1;j<n;j++){                     // iterates over the unsorted part
                    if(less(elements[maxIndex], elements[j])){  // if the current element (elements[j]) is greater than element at index maxIndex
                        maxIndex=j;                             // it means the new greatest element is at index j
                    }
                }
                swap(elements,i,maxIndex);          // after finding the maximum element, we swap it with the element at index i
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
