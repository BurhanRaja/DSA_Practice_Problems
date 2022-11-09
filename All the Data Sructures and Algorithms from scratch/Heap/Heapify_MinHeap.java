public class Heapify_MinHeap {

    static class Node {
        int cap;
        int size;
        int[] arr;

        Node (int c) {
            this.cap = c;
            arr = new int[cap];
            size=0;
        }

        public void insert(int x) {
            if (size == cap) {
                return;
            }
            else {
                arr[size] = x;
                size++;
                // for (int i = size-1; i > 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
                //     swap(arr, parent(i), i);
                // }
            }
        }

        // To make the Tree according to Min Heap
        public void heapify(int i){ 
            int left = left(i);
            int right = right(i);
            int smallest = i;

            if (left < size && arr[left] < arr[i]) {
                smallest = left;
            }
            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }

            if (smallest != i) {
                swap(arr, i, smallest);
                heapify(smallest);
            }
        }

        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        public void swap(int[] array, int a, int b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

        public int left(int i) {
            return (2*i)+1;
        }
        public int right(int i) {
            return (2*i)+2;
        }
        public int parent(int i) {
            return (i-1)/2;
        }
    }

    public static void main(String[] args) {
        Node h = new Node(10);
        h.insert(50);
        h.insert(40);
        h.insert(70);
        h.insert(10);
        h.insert(100);
        h.insert(60);
        h.insert(80);
        h.insert(20);
        h.insert(30);
        h.insert(90);

        h.printHeap();

        h.heapify(0);
        h.heapify(0);
        h.heapify(2);
        h.heapify(1);
        h.heapify(4);
        System.out.println();

        h.printHeap();
    }
}
