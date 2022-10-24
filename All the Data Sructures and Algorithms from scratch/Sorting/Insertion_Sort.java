
import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 5, 2 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // To sort the array by increasing the length of the array taken.
    // Start from 0 to 1
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }
                else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
