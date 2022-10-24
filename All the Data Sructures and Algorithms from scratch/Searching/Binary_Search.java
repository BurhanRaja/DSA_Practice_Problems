public class Binary_Search {
    public static void main(String[] args) {
        int[] arr = { 12, 19, 34, 45, 51, 60, 66, 72, 78, 80 };
        int ans = binarySearch(arr, 72);
        System.out.println(ans);
    }

    // **Simple Divide and Conquer**
    // OR
    // **Binary Search**

    static int binarySearch(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] > x) {
                e = m - 1;
            } else if (arr[m] < x) {
                s = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}