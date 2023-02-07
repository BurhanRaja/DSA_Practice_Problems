class StackArray {
    constructor() {
        this.stack = [];
    }
    push(val) {
        return this.stack.push(val);
    }
    pop() {
        return this.stack.pop();
    }
    peek() {
        return this.stack[this.stack.length - 1];
    }
    isEmpty() {
        return this.stack.length !== 0;
    }
}

class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class StackNode {
    constructor() {
        this.head = null;
        this.tail = this.head;
        this.size = 0;
    }

    push(val) {
        let node = new Node(val);
        if (!this.head) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
        return this;
    }

    
    isEmpty() {
        return this.size === 0;
    }

    pop() {
        if (!this.head) {
            return -1;
        }

        let curr = this.head;
        let newTail = curr;
        while(curr.next) {
            newTail = curr;
            curr = curr.next;
        }
        this.tail = newTail;
        this.tail.next = null;
        this.length--;
        if (this.isEmpty()) {
            this.head = null;
            this.tail = null;
        }
        return curr.value;
    }

    peek() {
        return this.tail.value;
    }

    printStack() {
        let curr = this.head;

        while (curr !== null) {
            console.log(curr.value);
            curr = curr.next;
        }
    }
}

let stk = new StackNode();

stk.push(1);
stk.push(2);
console.log(stk.peek());
console.log(stk.pop());
stk.printStack();

