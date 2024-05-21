package org.example.week7_midtermprep;
/*
selection sort algorithm
 */
public class task19 {
    public class SelectionSort {

        /* Selection sort algorithm */
        public static void sort(int[] elements) {
            int n=elements.length;

            for(int i=0;i<n-1;i++){                                 // iterate through array
                int minIndex=i;                                     // assume the current index is minimum
                for(int j=i+1; j<n;j++){                            // find index of the minimum in the unsorted part
                    if(less(elements[j], elements[minIndex])){      // if current element is smaller than assumed minimum
                        minIndex=j;                                 // then, that current element is now minimum
                    }
                }
                swap(elements,i,minIndex);                          // swap the minimum element with the first element of the unsorted part
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
