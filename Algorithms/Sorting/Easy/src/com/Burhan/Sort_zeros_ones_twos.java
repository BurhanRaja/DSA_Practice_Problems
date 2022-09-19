import java.util.Arrays;

public class Sort_zeros_ones_twos {
    public static void main(String[] args) {
        int[] arr = { 2, 0, 2, 0, 0, 1, 2, 2, 2, 1, 1, 0, 1, 1, 1, 2, 0, 1, 2, 1, 0, 1, 2, 0, 0, 0, 2, 0, 1, 0, 0, 0, 1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2, 0, 2, 0, 0, 2, 1, 2, 1, 1, 2, 1, 2, 0, 0, 1, 0, 2, 1, 1, 2, 0, 2, 0, 1, 2, 2, 2, 2, 1, 0, 1, 2, 2, 0, 1, 1, 1, 0, 1, 2, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0 };
        int[] ans = sort012(arr);
        System.out.println(Arrays.toString(ans));

    }

    static int[] sort012(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        
        while (mid <= hi) {
            if (a[mid] == 0) {
                swap(a, lo, mid);
                lo++;
                mid++;
            } else if (a[mid] == 2) {
                swap(a, hi, mid);
                hi--;
            } else {
                mid++;
            }
        }
        return a;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
