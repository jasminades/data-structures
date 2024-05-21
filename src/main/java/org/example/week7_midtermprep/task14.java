package org.example.week7_midtermprep;
/*
sequential linear search algorithm
 */
public class task14 {
    public class SequentialSearch {
        /* Sequential search algorithm for integer arrays */
        // your code
        public static int search(int[] elements, int key) {
            for(int i=0; i<elements.length;i++){
                if(elements[i]==key){
                    return i;
                }
            }
            return -1;
        }
    }
}
