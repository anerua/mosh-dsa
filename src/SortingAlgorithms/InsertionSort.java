package SortingAlgorithms;

public class InsertionSort {

    public void sort(int[] items) {
        for (int i = 1; i < items.length; i++) {
            int current = items[i];
            int j = i - 1;
            while (j >= 0 && items[j] > current) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = current;
        }
    }

}
