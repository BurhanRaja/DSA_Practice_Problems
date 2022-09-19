import java.util.Arrays;

public class Convert_to_wave {
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};
        int[] arr = {2,4,7,8,9,10};
        int[] ans = waveArray(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] waveArray(int[] arr) {
        int i = 0;
        while (i < arr.length && i+1 < arr.length) {
            swap(arr, i, i+1);
            i+=2;
        }

        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
