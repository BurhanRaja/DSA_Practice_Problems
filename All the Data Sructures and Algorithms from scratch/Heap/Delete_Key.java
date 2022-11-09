public class Delete_Key {

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
                for (int i = size-1; i != 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
                    swap(arr, parent(i), i);
                }
            }
        }

        public void delete(int i) {
            arr[i] = Integer.MIN_VALUE;
            while(i != 0 && arr[parent(i)] > arr[i]) {
                swap(arr, parent(i), i);
                i = parent(i);
            }
            getMin();
        }

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

        public int getMin() {
            if (size == 0) {
                return -1;
            }
            if (size == 1) {
                return arr[0];
            }
            swap(arr, 0, size-1);
            size--;
            heapify(0);
            return arr[size];
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
        Node n = new Node(5);
        n.insert(10);
        n.insert(20);
        n.insert(50);
        n.insert(40);
        n.insert(80);

        n.printHeap();

        n.delete(n.left(1));

        n.printHeap();
    }
}
