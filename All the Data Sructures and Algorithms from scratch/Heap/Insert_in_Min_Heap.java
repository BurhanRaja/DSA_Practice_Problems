public class Insert_in_Min_Heap {

    static class MyHeap{
        int[] arr;
        int size;
        int cap;

        MyHeap(int c) {
            this.arr = new int[c];
            this.cap = c;
            this.size = 0;
        }

        public void insert(int x) {
            if (size == cap) {
                return;
            }
            arr[size] = x;
            size++;
            for (int i = size-1; i != 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
                swap(arr, parent(i), i);
            }
        }

        protected void swap(int[] heap, int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }

        // i = index of an array.
        public int left(int i) {
            return (2*i+1);
        }
        public int right(int i) {
            return (2*i+2);
        }
        public int parent(int i) {
            return (i-1)/2;
        }

        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        MyHeap h = new MyHeap(10);
        h.insert(20);
        h.insert(40);
        h.insert(10);
        h.insert(50);
        h.insert(30);
        h.insert(60);
        h.insert(80);
        h.insert(70);
        h.insert(100);
        h.insert(90);

        h.printHeap();
    }
}
