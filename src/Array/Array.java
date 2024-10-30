package Array;

import java.util.Arrays;

/**
 *
 * @author anerua
 */
public class Array {
    private int[] array;
    private int tail = 0;
    private int length = 0;

    public Array(int length) {
        this.length = length;
        this.array = new int[length];
        // this.tail = (length > 0) ? length - 1 : 0;
    }

    public void insert(int item) {
        if (this.length > 0 && this.tail < this.length) {
            this.array[this.tail] = item;
            ++this.tail;
        } 
        else {
            ++this.length;
            this.array = Arrays.copyOf(this.array, length);
            this.array[this.tail] = item;
            ++this.tail;
        }
    }

    public void removeAt(int index) {
        if (index >= this.tail) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        int i = index;
        while (i < this.tail - 1) {
            this.array[i] = this.array[i + 1];
            ++i;
        }
        --tail;
    }

    public int indexOf(int item) {
        for (int i = 0; i < this.tail; i++) {
            if (this.array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < this.tail; i++) {
            System.out.println(this.array[i]);
        }
    }
}
