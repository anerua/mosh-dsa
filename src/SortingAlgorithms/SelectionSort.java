package SortingAlgorithms;

public class SelectionSort {

    public void sort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int minIndex = i;
            for (int j = i; j < items.length; j++)
                if (items[j] < items[minIndex])
                    minIndex = j;
                    
            if (minIndex != i)
                swap(items, i, minIndex);
        }
    }

    private void swap(int[] items, int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

}
