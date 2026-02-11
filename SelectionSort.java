public class SelectionSort {
    public static <T extends Comparable<T>> void selectionSort(T[] array) {

        for(int i = 0; i < array.length - 1; i++) {
            int min = i;
    
            for(int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}