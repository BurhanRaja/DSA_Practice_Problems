import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        int[] ans = cyclicSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            }
            else {
                i++;
            }
        }

        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
