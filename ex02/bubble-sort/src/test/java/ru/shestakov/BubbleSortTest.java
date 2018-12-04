package ru.shestakov;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTest {

    private static final int MAX = 100;
    private int[] unsortedArray;

    @Before
    public void init() {
        this.unsortedArray = new int[this.MAX];
        for (int i=0; i<this.unsortedArray.length; i++) {
            this.unsortedArray[i] = getRandomInt();
        }
    }

    @Test
    public void whenUnsortedArrayThenSortIt() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.setArray(this.unsortedArray);
        showArray(bubbleSort.getArray());
        bubbleSort.doSort();
        showArray(bubbleSort.getArray());
    }

    private int getRandomInt() {
        Random r = new Random();
        return r.nextInt(this.MAX);
    }

    private void showArray(int[] array) {
        System.out.print(Arrays.toString(array));
        System.out.println("");
    }

}