package no.hvl.dat107.sorting;

import java.util.stream.IntStream;

public class ShellSort {

	
	private static Comparable[] arr = {5, 2, 8, 4, 1, 9, 3, 7, 6}; // Example array for demonstration

    
	public static void main(String[] args) {
        sort();
        for (Comparable item : arr) {
            System.out.print(item + " ");
        }
    }

    
	private static void sort() {
        IntStream.iterate(arr.length / 2, gap -> gap > 1, gap -> gap / 2)
                .forEach(gap -> IntStream.range(gap, arr.length)
                        .forEach(index -> {
                            int j = index;
                            while (j >= gap && arr[j - gap].compareTo(arr[j]) > 0) {
                                swap(j, j - gap);
                                j -= gap;
                            }
                        }));
    }

    
	private static void swap(int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
