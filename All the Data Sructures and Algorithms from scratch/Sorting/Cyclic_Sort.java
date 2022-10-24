import java.util.Arrays;

public class Cyclic_Sort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 5, 2 };
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // If 1 to N
    // not 0 to N
    // To swap the elements with their respective index i.e. ** index = element - 1; **
    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i != arr.length-1) {
            if (arr[0] == 1) {
                i++;
            }
            int index = arr[i] - 1;
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
