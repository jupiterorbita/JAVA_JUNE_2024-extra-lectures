/**
 * A class to represents a single item of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
 */
class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * This class keeps track of the start (head) of the list and to store all the
 * functionality (methods) that each list should have.
 */
class SinglyLinkedList {
    constructor() {
        this.head = null;
    }

    isEmpty() {
        return this.head === null;
    }

    insertAtBack(data) {
        const newBack = new ListNode(data);

        if (this.isEmpty()) {
            this.head = newBack;
            return this;
        }

        let runner = this.head;

        while (runner.next !== null) {
            runner = runner.next;
        }

        runner.next = newBack;
        return this;
    }

    insertAtBackRecursive(data, runner = this.head) {
        if (this.isEmpty()) {
            this.head = new ListNode(data);
            return this;
        }

        if (runner.next === null) {
            runner.next = new ListNode(data);
            return this;
        }
        return this.insertAtBackRecursive(data, runner.next);
    }

    insertAtBackMany(vals) {
        for (const item of vals) {
            this.insertAtBack(item);
        }
        return this;
    }

    toArr() {
        const arr = [];
        let runner = this.head;

        while (runner) {
            arr.push(runner.data);
            runner = runner.next;
        }
        return arr;
    }

    insertAtFront(data) {
        const newHead = new ListNode(data);
        newHead.next = this.head;
        this.head = newHead;
        return this;
    }

    removeHead() {
        if (this.isEmpty()) {
            return null;
        }

        const oldHead = this.head;
        this.head = oldHead.next;
        return oldHead.data;
    }

    average() {
        let runner = this.head;
        let sum = 0;
        let cnt = 0;

        while (runner) {
            cnt++;
            sum += runner.data;
            runner = runner.next;
        }

        /**
         * Dividing by 0 will give you NaN (Not a Number), so an empty list
         * will return NaN in this case, it may make sense to allow NaN to be
         * returned, because the average of an empty list doesn't make sense and
         * it could be misleading to return 0 since 0 is the average of any
         * list with a sum of 0 (due to negatives or all zeros).
         */
        return sum / cnt;
    }

    removeBack() {
        if (this.isEmpty()) {
            return null;
        }

        // Only 1 node.
        if (this.head.next === null) {
            return this.removeHead();
        }

        // More than 1 node.
        let runner = this.head;

        while (runner.next.next) {
            runner = runner.next;
        }

        // after while loop finishes, runner is now at 2nd to last node
        const removedData = runner.next.data;
        runner.next = null; // remove it from list
        return removedData;
    }

    contains(val) {
        let runner = this.head;

        while (runner) {
            if (runner.data === val) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    containsRecursive(val, current = this.head) {
        if (current === null) {
            return false;
        }
        if (current.data === val) {
            return true;
        }
        return this.containsRecursive(val, current.next);
    }

    recursiveMax(runner = this.head, maxNode = this.head) {
        if (this.head === null) {
            return null;
        }

        if (runner === null) {
            return maxNode.data;
        }

        if (runner.data > maxNode.data) {
            maxNode = runner;
        }

        return this.recursiveMax(runner.next, maxNode);
    }

    secondToLast() {
        let runner = this.head;
        if (runner === null || runner.next === null) {
            return null;
        }
        while (runner.next.next) {
            runner = runner.next;
        }
        return runner.data;
    }

    removeVal(val) {
        let runner = this.head;
        if (runner === null) {
            return false;
        }

        if (runner.data === val) {
            this.head = runner.next;
            return true;
        }

        while (runner.next !== null) {
            if (runner.next.data === val) {
                runner.next = runner.next.next;
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    prepend(newVal, targetVal) {
        const newData = new ListNode(newVal);
        if (this.isEmpty()) {
            return false;
        }

        let runner = this.head;
        if (runner.data === targetVal) {
            this.insertAtFront(newVal);
            return true;
        }

        while (runner.next) {
            if (runner.next.data === targetVal) {
                newData.next = runner.next;
                runner.next = newData;
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    // ==========================================================================
    // NEW PROBLEMS =============================================================
    // ==========================================================================
    /**
     * Concatenates the nodes of a given list onto the back of this list.
     * @param {SinglyLinkedList} addList An instance of a different list whose
     *    whose nodes will be added to the back of this list.
     * @returns {SinglyLinkedList} This list with the added nodes.
     */
    concat(addList) {
        if (this.isEmpty()) {
            this.head = addList.head; // the .head is the start of the list
            return this;
        }

        let runner = this.head;

        while (runner.next) {
            runner = runner.next;
        }

        runner.next = addList.head;
        return this;
    }

    /**
     * Finds the node with the smallest data and moves that node to the front of
     * this list.
     * @returns {SinglyLinkedList} This list.
     */
    moveMinToFront() {
        if (this.isEmpty()) {
            return this;
        }

        let minNode = this.head;
        let runner = this.head;

        while (runner) {
            if (runner.data < minNode.data) {
                minNode = runner;
            }
            runner = runner.next;
        }

        if (minNode === this.head) {
            return this;
        }

        runner = this.head;
        while (runner.next !== minNode) {
            runner = runner.next;
        }

        runner.next = minNode.next;
        minNode.next = this.head;
        this.head = minNode;
        return this;
    }

    // EXTRA
    /**
     * Splits this list into two lists where the 2nd list starts with the node
     * that has the given value.
     * splitOnVal(5) for the list (1=>3=>5=>2=>4) will change list to (1=>3)
     * and the return value will be a new list containing (5=>2=>4)
     * @param {any} val The value in the node that the list should be split on.
     * @returns {SinglyLinkedList} The split list containing the nodes that are
     *    no longer in this list.
     */
    splitOnVal(val) {
        const newList = new SinglyLinkedList();
        if (this.isEmpty()) {
            return newList;
        }

        if (this.head.data === val) {
            newList.head = this.head;
            this.head = null;
            return newList;
        }

        let runner = this.head;
        while (runner.next) {
            if (runner.next.data === val) {
                newList.head = runner.next;
                runner.next = null;
                return newList;
            }
            runner = runner.next;
        }
        return newList;
    }

    // reverse a singly linked list
    /**
     * Reverses this list in-place.
     * @returns {SinglyLinkedList} This list.
     * @description Reverses this list in-place.
     * @example
     * const list = new SinglyLinkedList();
     * list.insertAtBack(1).insertAtBack(2).insertAtBack(3);
     * list.reverse();
     * console.log(list.toArr()); // should log [3, 2, 1]
     */
    reverse() {
        let prev = null;
        let current = this.head;
        let next = null;

        while (current !== null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
        return this;
    }

}

const myCoolList = new SinglyLinkedList().insertAtBackMany([11, 22, 33, 44]);

const anotherList = new SinglyLinkedList().insertAtBackMany([1, 2, 3, 4, 5]);

myCoolList.concat(anotherList);

console.log(myCoolList.toArr()); // should log [11, 22, 33, 44, 1, 2, 3, 4, 5]

myCoolList.moveMinToFront();
console.log(myCoolList.toArr()); // should log [1, 11, 22, 33, 44, 2, 3, 4, 5]

const splitList = myCoolList.splitOnVal(22);
console.log(myCoolList.toArr()); // should log [1, 11]
console.log(splitList.toArr()); // should log [22, 33, 44, 2, 3, 4, 5]

myCoolList.reverse();
console.log(myCoolList.toArr()); // should log [11, 1]