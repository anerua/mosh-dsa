package SortingAlgorithms;

public class BubbleSort {

    public void sort(int[] items) {
        boolean isSorted;
        for (int i = 0; i < items.length; i++) {
            isSorted = true;
            for (int j = 1; j < items.length - i; j++)
                if (items[j] < items[j - 1]) {
                    swap(items, j, j - 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    private void swap(int[] items, int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
