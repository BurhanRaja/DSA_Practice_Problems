class QueueArr {
    constructor() {
        this.arr = [];
    }

    push(val) {
        return this.arr.push(val);
    }

    pop() {
        let temp = this.arr[0];
        for (let i = 0; i < this.arr.length - 1; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.arr.length--;
        return temp;
    }
    isEmpty() {
        return this.size === 0;
    }

    peek() {
        return this.arr[0];
    }

    print() {
        this.arr.forEach((el) => console.log(el));
    }
}


class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class QueueNode {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}

let q = new QueueArr();
q.push(1);
q.push(4);
q.push(2);
q.push(6);
q.push(5);
q.push(8);
q.push(10);
// q.print();
q.print();