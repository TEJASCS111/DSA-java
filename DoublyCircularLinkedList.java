class DoublyCircularLinkedList {
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    void delete(int data) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.data == data) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == head) head = temp.next;
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void display() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display(); // Output: 10 20 30
        list.delete(20);
        list.display(); // Output: 10 30
    }
}
