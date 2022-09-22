package com.Burhan;

public class Implement_Two_Stacks_in_an_Array {

    static class MyTwoStack {
        int[] arr;
        int cap;
        int size1;
        int size2;

        MyTwoStack(int n) {
            arr = new int[n];
            cap = n;
            size1 = 0;
            size2 = cap-1;
        }

        public boolean push1(int x) {
            if (size1 > size2) {
                return false;
            }
            else {
                arr[size1] = x;
                size1++;
                return true;
            }
        }

        public boolean push2(int x) {
            if (size2 < size1) {
                return false;
            }
            else {
                arr[size2] = x;
                size2--;
                return true;
            }
        }

        public int pop1() {
            if (size1 < 0){
                return Integer.MIN_VALUE;
            }
            else {
                size1--;
                int x = arr[size1];
                arr[size1] = 0;
                return x;
            }
        }
        
        public int pop2() {
            if (size2 == cap){
                return Integer.MIN_VALUE;
            }
            else {
                size2++;
                int x = arr[size2];
                arr[size2] = 0;
                return x;
            }
        }

        public int size1() {
            return size1;
        }
        public int size2() {
            return cap-size2-1;
        }

        public void printStack1() {
            System.out.print("[ ");
            for (int i = 0; i < size1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(" ]");
        }
        
        public void printStack2() {
            System.out.print("[ ");
            for (int i = cap-1; i > size2 ; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        MyTwoStack s = new MyTwoStack(4);
        
        
        System.out.println(s.push1(10));
        System.out.println(s.push2(30));

        s.push1(20);
        s.push2(40);

        System.out.println(s.size1());
        System.out.println(s.size2());

        System.out.println(s.push1(3));
        // System.out.println(s.pop2());

        s.printStack1();
        s.printStack2();

    }

}
