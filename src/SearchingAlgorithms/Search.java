package SearchingAlgorithms;

public class Search {

    public int linearSearch(int[] items, int target) {
        for (int i = 0; i < items.length; i++)
            if (items[i] == target)
                return i;
        
        return -1;
    }

    public int binarySearchRecursive(int[] items, int target) {
        return binarySearchRecursive(items, target, 0, items.length - 1);
    }

    private int binarySearchRecursive(int[] items, int target, int left, int right) {
        if (left > right)
            return -1;
        
        int middleIndex = (left + right) / 2;
        if (target == items[middleIndex])
            return middleIndex;

        if (target > items[middleIndex])
            return binarySearchRecursive(items, target, middleIndex + 1, right);
        
        return binarySearchRecursive(items, target, left, middleIndex - 1);
    }

    public int binarySearchIterative(int[] items, int target) {
        int left = 0;
        int right = items.length - 1;
        
        while (right >= left) {
            int middleIndex = (left + right) / 2;
            if (target == items[middleIndex])
                return middleIndex;
            
            if (target > items[middleIndex])
                left = middleIndex + 1;
            else
                right = middleIndex - 1;
        }

        return -1;
    }

    public int ternarySearch(int[] items, int target) {
        return ternarySearch(items, target, 0, items.length - 1);
    }

    private int ternarySearch(int[] items, int target, int left, int right) {
        if (left > right)
            return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;
        
        if (target == items[mid1])
            return mid1;
        
        if (target == items[mid2])
            return mid2;
        
        if (target < items[mid1])
            return ternarySearch(items, target, left, mid1 - 1);
        
        if (target > items[mid1] && target < items[mid2])
            return ternarySearch(items, target, mid1 + 1, mid2 - 1);

        return ternarySearch(items, target, mid2 + 1, right);
    }

    public int jumpSearch(int[] items, int target) {
        int blockSize = (int) Math.sqrt(items.length);
        int start = 0;
        int next = start + blockSize;
        while (start < items.length) {
            if (next > items.length)
                next = items.length;

            if (target <= items[next - 1])
                return linearSearchForJumpSearch(items, target, start, next - 1);
            
            start = next;
            next = start + blockSize;
        }

        return -1;
    }

    private int linearSearchForJumpSearch(int[] items, int target, int start, int end) {
        for (int i = start; i <= end; i++)
            if (target == items[i])
                return i;

        return -1;
    }
}
