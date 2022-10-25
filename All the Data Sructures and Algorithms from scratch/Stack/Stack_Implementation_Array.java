public class Stack_Implementation_Array {

    static class MyStack1 {
        int[] arr;
        int top;
        int cap;

        MyStack1(int c) {
            this.cap = c;
            this.arr = new int[c];
            this.top = -1;
        }

        void push(int x) {
            if (top + 1 == cap) {
                try {
                    throw new Exception("The size of the array is full.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                top++;
                arr[top] = x;
            }
        }

        int pop() {
            if (top < 0) {
                try {
                    throw new Exception("The array is empty.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1;
            } else {
                int ans = arr[top];
                arr[top] = 0;
                top--;
                return ans;
            }
        }

        int peek() {
            if (top < 0) {
                try {
                    throw new Exception("The array is empty.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1;
            } else {
                return arr[top];
            }
        }
    }

    public static void main(String[] args) {
        MyStack1 s = new MyStack1(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println(s.peek());
        
        System.out.println(s.pop());
        
        System.out.println(s.peek());
    }
}