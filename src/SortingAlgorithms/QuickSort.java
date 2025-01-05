package SortingAlgorithms;

public class QuickSort {

    public void sort(int[] items) {        
        sort(items, 0, items.length - 1);
    }

    private void sort(int[] items, int startIndex, int stopIndex) {
        if (stopIndex - startIndex < 1)
            return;

        int pivotIndex = partition(items, startIndex, stopIndex);
    
        sort(items, startIndex, pivotIndex - 1);
        sort(items, pivotIndex + 1, stopIndex);
    }

    private int partition(int[] items, int startIndex, int stopIndex) {
        int pivot = items[stopIndex];

        int boundary = startIndex - 1;
        for (int i = startIndex; i <= stopIndex; i++)
            if (items[i] <= pivot)
                swap(items, ++boundary, i);

        return boundary;
    }

    private void swap(int[] items, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex)
            return;

        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }
}
