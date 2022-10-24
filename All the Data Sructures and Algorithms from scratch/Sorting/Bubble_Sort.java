import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 5, 2 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // To swap two adjacent elements if [left element] > [right element]
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}