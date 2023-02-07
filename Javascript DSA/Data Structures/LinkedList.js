class Node {
    constructor(key) {
        this.key = key;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.length = 0;
        this.tail = null;
    }

    // Add an element
    push(val) {
        const node = new Node(val);
        if (!this.head) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node; // attaching the next of tail to the curr Node;
            this.tail = node; // changing the tail to the curr Node;
        }
        this.length++;
        return this;
    }

    pop() {
        if (!this.head) {
            return undefined;
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
        return curr;
    }

    // Get element on index
    getVal(index) {
        if (index < 0 || index >= this.length) {
            return null;
            
        } else {
            let count = 0;
            let curr = this.head;
            while (count !== index) {
                curr = curr.next;
                count++;
            }
            return curr;
        }
    }

    setVal(index, key) {
        let fountNode = this.getVal(index);
        if (fountNode) {
            fountNode.key = key;
            return true;
        } else {
            return false;
        }
    }

    insert(index, key) {
        if (index < 0 || index > this.length) return undefined;
        if (index === this.length) return this.push(key);
        if (index === 0) {
            const newNode = new Node(key);
            newNode.next = this.head;
            this.head = newNode;
            this.length++;
            return this.head;
        }
        const newNode = new Node(key);
        const prev = this.getVal(index - 1);
        const temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;
        this.length++;
        return newNode;
    }

    remove(index) {
        if (index < 0 || index > this.length) return undefined;
        if (index === 0) {
            this.head = this.head.next;
            this.length--;
            return this.head;
        }
        if (index === this.length-1) {
            return this.pop();
        }
        let previousNode = this.getVal(index - 1);
        let removedIndex = previousNode.next;
        previousNode.next = removedIndex.next;
        this.length--;

        return removedIndex;
    }

    reverse() {
        let node = this.head;
        this.head = this.tail;
        this.tail = node;
        let next;
        let prev = null;
        for (let i = 0; i < this.length; i++) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }


        return this.head;
    }


    // Print all the LinkedList elements;
    getLinkedList() {
        let array = [];
        while(this.head) {
            array.push(this.head.key);
            this.head = this.head.next;
        }
        return array;
    }

    // Get the size of linkedlist;
    size() {
        return this.length;
    }

    isEmpty() {
        return this.length === 0;
    }

    
}

let n = new LinkedList();
n.push(12);
n.push(13);
n.push(14);
n.push(15);
n.setVal(2, 90);
n.insert(0, 23);
n.remove(0);
n.reverse();
// console.log(n.getLinkedList());

let addNum = (x, y) => x+y;
let mult3 = (fn) => (x, y) => fn(x*3, y*3);
let addNumMlt3 = mult3(addNum);
console.log(addNumMlt3(10, 20));
