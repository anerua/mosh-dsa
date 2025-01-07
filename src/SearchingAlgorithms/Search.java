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
}
