package org.example.week7_midtermprep;

/*
bubble sort
 */
public class task7 {
    public class BubbleSort {

        /* Bubble sort algorithm */
        // your code
        public static void sort(int[] elements) {
            int n=elements.length;
            boolean swapped;

            for(int i=0; i<n-1;i++){                // looping from the beginning of the array up to second-to-last element
                swapped=false;

                for(int j=0; j<n-i-1; j++){         // looping through the unsorted portion of the array
                    if(!less(elements[j],elements[j+1])){  // checking if the current element (elements[j]) is greater than or equal to the next element (elements[j+1)*])
                        swap(elements,j,j+1);           // if yes, they swap
                        swapped=true;
                    }
                }
                // after passing through the whole array, if no elements are swapped, it means the array is already sorted
                if(!swapped){
                    break;
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
