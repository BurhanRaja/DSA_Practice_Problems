package com.Burhan;

public class Pascal_Triangle {
    public static void main(String[] args) {
        int n = 15;
        // pascalTriangleEff(n);
        int a = (int) factorial(n);
        int b = (int) factorial(n - 2);
        int c = (int) factorial(2);

        System.out.print(a + " " + b + " " + c);
    }

    // Naive
    static void pascalTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                long num = nCr(n, i);
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }

    // Efficient
    static void pascalTriangleEff(int n) {
        int C = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(C + " ");
            C = C * (n - i) / i;
        }
    }

    static long factorial(int i) {
        if (i == 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }

    static long nCr(int n, int i) {
        return factorial(n) / (factorial(n-i) * factorial(i));
    }


    
}