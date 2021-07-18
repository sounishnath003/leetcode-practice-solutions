/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
​
/**
 * LinkedListt
 */
class LinkedListt {
​
    ListNode head;
    ListNode tail;
    int size = 0;
​
    LinkedListt() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
​
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
​
        if (this.head == null && this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
​
        this.size++;
    }
​
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
​
        if (this.head == null && this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
​
        this.size++;
    }
