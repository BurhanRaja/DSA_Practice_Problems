package com.Burhan;


public class Print_all_Substring_Except_AB {
    public static void main(String[] args) {
        String str = "ABC";
        permutate(str.toCharArray(), 0, str.length()-1);
    }

    static boolean isSafe(char[] str, int l, int i, int r) {
        if (l != 0 && str[l-1] == 'A' && str[i] == 'B') {
            return false;
        }
        if (r == l+1 && str[i] == 'A' && str[l] == 'B' || r == l + 1 && l == i && str[r] == 'B' && str[l] == 'A') {
            return false;
        }
        return true;
    }

    static void permutate(char[] str, int l, int r) {
        if (l == r) {
            if (!String.valueOf(str).contains("AB")) {
                System.out.print(String.valueOf(str) + " ");
                return;
            }
        }

        for (int i = l; i <= r; i++) {
            if (isSafe(str, l, i, r)) {
                swap(str, l, i);
                permutate(str, l+1, r);
                swap(str, l, i);
            }
        }
    }

    static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}