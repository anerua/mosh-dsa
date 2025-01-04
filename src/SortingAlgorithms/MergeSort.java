package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] items) {
        if (items.length < 2)
            return;

        int[] firstPart = Arrays.copyOfRange(items, 0, items.length / 2);
        int[] secondPart = Arrays.copyOfRange(items, items.length / 2, items.length);
        
        sort(firstPart);
        sort(secondPart);

        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (firstIndex == firstPart.length)
                items[i] = secondPart[secondIndex++];
            else if (secondIndex == secondPart.length)
                items[i] = firstPart[firstIndex++];
            else if (firstPart[firstIndex] < secondPart[secondIndex])
                items[i] = firstPart[firstIndex++];
            else
                items[i] = secondPart[secondIndex++];
        }
    }
}
