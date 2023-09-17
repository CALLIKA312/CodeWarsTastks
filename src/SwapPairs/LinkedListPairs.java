package SwapPairs;

public class LinkedListPairs {

    public static void main(String[] args) {
        Node head = new Node("A");
        head.next = new Node("B");
//        head.next.next = new Node("C");
//        head.next.next.next = new Node("D");
        System.out.println(head.printList());

//        Node head = new Node("A");
        head = swapPairs(head);

        System.out.println(head.printList());
    }

//        queue.enqueue(new Animal("Dog", "Silver1"));
//        queue.enqueue(new Animal("cat", "Silver2"));
//        queue.enqueue(new Animal("Dog", "Silver3"));
//        queue.enqueue(new Animal("Dog", "Silver4"));
//        queue.enqueue(new Animal("Dog", "Silver5"));
//        queue.dequeueDog();
//        queue.enqueue(new Animal("Dog", "Silver6"));
//        queue.dequeueDog();
//        queue.dequeueAny();
//        System.out.println(queue);

    public static Node swapPairs(Node head) {
        Node cur = head;
        Node second;
        Node old;
        if (head == null) return head;
        if (cur.next != null) second = cur.next;
        else return head;
        head = second;
        cur.next = second.next;
        second.next = cur;
        old = cur;
        cur = cur.next;
        if (cur == null) return head;
        second = cur.next;
        while (cur.next != null) {
            if (second.next == null) break;
            old.next = second;
            cur.next = second.next;
            second.next = cur;
            old = cur;
            cur = cur.next;
            second = cur.next;
        }
        if (cur.next != null) {
            old.next = second;
            second.next = cur;
            cur.next = null;
        }

        return head;
    }
}
