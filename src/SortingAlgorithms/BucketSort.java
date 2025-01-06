package SortingAlgorithms;

import java.util.LinkedList;

public class BucketSort {

    public void sort(int[] items, int numberOfBuckets) {
        LinkedList<Integer>[] buckets = new LinkedList[numberOfBuckets];
        
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<Integer>();

        for (int item : items)
            buckets[item / numberOfBuckets].add(item);
        
        int insertIndex = 0;
        for (var bucket : buckets) {
            bucket.sort(null);
            for (int item : bucket)
                items[insertIndex++] = item;
        }
    }
}
