package com.Burhan;

public class Pascal_Triangle {
    public static void main(String[] args) {
        int n = 4;
        pascalTriangleEff(n);
    }


// Naive
    static void pascalTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = factorial(i)/(factorial(i-j)*factorial(j));
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }
    
    // Efficient
    static void pascalTriangleEff(int n) {
        int num = 0;
        for (int i = 0; i <= n; i++) {
            num = factorial(n)/(factorial(n-i)*factorial(i));
            System.out.print(num + " ");
        }
    }

    static int factorial(int i) {
        if (i == 0) {
            return 1;
        }
        return i * factorial(i-1);
    }
}