// WIP as of Feb. 7, 2026

// Reference for assistance - https://www.youtube.com/watch?v=EwjnF7rFLns

public class SelectionSort {
    /*
    The following code below was just creating a foundation for building the selectionSort class.
    
    public static void main(String[] args) {
        int array[] = {9, 2, 1, 4, 3, 7, 6, 11};

        selectionSort(array);

        for(int i : array) {
            System.out.println(i);
        }
    }
   */

    // Below is the selection sort algorithm.

    // This public static method was changed from int to T in order to account for other data types.
    public static <T extends Comparable<T>> void selectionSort(T[] array) {

        // The following for loop is the beginning of the variable.
        // It begins with 0 as a starting point to work off of all the upcoming numbers.
        // This is to keep running until before the very last item is reached.

        /*
        Explanation i < array.length -1 (REMOVE OR AT LEAST MODIFY IN MY OWN WORDS);
        The "Why": This is the most important part.Imagine you have 5 cards.
        If you successfully find the correct spots for the first 4 cards, the 5th card is automatically in the right place. 
        There is nothing left to compare it to! Therefore, you don't need to run the sorting logic for the final item. 
        It saves the computer one useless step.
         */

        // The i++ is to continue to the next number.
        // Everything to the left of i is considered sorted.
        for(int i = 0; i < array.length - 1; i++) {

            // Assuming the first variable is the shorted. Using a temporary "label" to 
            int min = i;
            
            /* 
            The following inner loop is to scan the rest of the array and see if
            there's anything smaller than the current minimum.
            */
            for(int j = i + 1; j < array.length; j++) {

                /*This if statement is to see if the smallest value is actually the larger variable when compared to j?
                If yes, then update the minimum of j.
                */
                // The above comment is only for this old code snippet. 
                // if (array[min] > array[j])
                // The compareTo() method returns a negative number if the object on the left is smaller on than the object on the right.
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }

            // This is basically swapping the smaller number with the other larger number that was being compared to it.
            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}