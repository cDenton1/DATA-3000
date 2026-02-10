public class QuickSort {

	public static <T extends Employee> void sort(T[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static <T extends Employee> void quickSort(T[] array, int low, int high) {
		if (low < high) {
			int p = partition(array, low, high);
			quickSort(array, low, p -1);
			quickSort(array, p + 1, high);
		}
	}
	
	private static <T extends Employee> int partition(T[] array, int low, int high) {
		String pivot = array[high].getName();
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j].getName().compareToIgnoreCase(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return i + 1;
	}
	
	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
