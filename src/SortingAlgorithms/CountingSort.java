package SortingAlgorithms;

public class CountingSort {

    public void sort(int[] items, int max) {
        int[] countArray = new int[max + 1];
        for (int item : items)
            countArray[item]++;
        
        int insertIndex = 0;
        for (int i = 0; i < countArray.length; i++)
            for (int j = 0; j < countArray[i]; j++)
                items[insertIndex++] = i;
    }
}
