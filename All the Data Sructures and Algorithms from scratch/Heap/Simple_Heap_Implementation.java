public class Simple_Heap_Implementation {

    static class MyHeap{
        int[] arr;
        int size;
        int cap;

        MyHeap(int c) {
            this.arr = new int[c];
            this.cap = c;
            this.size = 0;
        }

        void insert(int x) {
            arr[size] = x;
            size++;
        }

        // i = index of an array.
        int left(int i) {
            return (2*i+1);
        }
        int right(int i) {
            return (2*i+2);
        }
        int parent(int i) {
            return (i-1)/2;
        }
    }

    public static void main(String[] args) {
        MyHeap h = new MyHeap(10);
        h.insert(10);
        h.insert(40);
        h.insert(20);
        h.insert(50);
        h.insert(30);
        h.insert(60);
        h.insert(80);
        h.insert(70);
        h.insert(100);
        h.insert(90);
        //  0    1   2   3   4   5   6   7   8    9 - index
        // [10, 40, 20, 50, 30, 60, 80, 70, 100, 90]
        System.out.println(h.left(3));
        System.out.println(h.right(3));
        System.out.println(h.parent(3));
    }

}