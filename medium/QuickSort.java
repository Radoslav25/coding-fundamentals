package no.hvl.dat107.sorting;

import java.util.Random;

public class QuickSort {
	private static final int INSERTION_SORT_THRESHOLD = 50; // Threshold for switching to insertion sort
	public static void main(String[] args) {
		
		Random rand = new Random();
		int[] array = new int[10000000];
		for (int i = 0; i < array.length; i++) {
		array[i] = rand.nextInt();
		}	
		Long start = System.currentTimeMillis();
		quicksort(array);
		Long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
	private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (highIndex - lowIndex <= INSERTION_SORT_THRESHOLD) {
            insertionSort(array, lowIndex, highIndex);
            return;
        }

        int pivotIndex = partition(array, lowIndex, highIndex);
        quicksort(array, lowIndex, pivotIndex - 1);
        quicksort(array, pivotIndex + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int i = lowIndex - 1;

        for (int j = lowIndex; j < highIndex; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, highIndex);
        return i + 1;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void insertionSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
