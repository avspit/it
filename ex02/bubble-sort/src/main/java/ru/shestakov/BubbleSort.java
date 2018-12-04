package ru.shestakov;

public class BubbleSort {

	private int[] array;

	public int[] getArray() {
		return this.array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public void doSort() {
		int[] array = this.array;
		for (int x=0; x<array.length-1; x++) {
			for (int y=0; y<array.length-1-x; y++) {
				if (array[y] > array[y+1]) {
					int temp = array[y];
					array[y] = array[y+1];
					array[y+1] = temp;
				}
			}
		}
	}

}