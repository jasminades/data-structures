package org.example.week7_midtermprep;
/*
bubble sort algorithm for integer data, to sort the data in descending order, by filling in the
missing code in the sort() method
 */
public class task12 {
    public class BubbleSort {

        /* Bubble sort algorithm (reverse sorting) */
        // your code here
        public static void sort(int[] elements) {
            int n=elements.length;                      // number of iterations needed
            for(int i=0; i<elements.length-1;i++){
                for(int j=0;j<n-i-1;j++){
                    if(!less(elements[j+1],elements[j])){       // compares the element at j+1 and j
                        swap(elements,j+1,j);                // if element at j+1 is greater than element j, then swap method is called
                    }
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
