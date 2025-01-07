package SearchingAlgorithms;

public class Search {

    public int linearSearch(int[] items, int target) {
        for (int i = 0; i < items.length; i++)
            if (items[i] == target)
                return i;
        
        return -1;
    }
}
