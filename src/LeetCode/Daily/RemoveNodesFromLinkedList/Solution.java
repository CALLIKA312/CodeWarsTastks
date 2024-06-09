package LeetCode.Daily.RemoveNodesFromLinkedList;

class Solution {
    public static ListNode removeNodes(ListNode head) {
        if (head.next == null) return head;

        ListNode maxNode = head;
        ListNode prevEndNode;
        while (head.next.next != null) {
            if (maxNode.val < head.val) {
                maxNode = head;
            }
            head = head.next;
        }
        prevEndNode = head;
        if (prevEndNode.val < prevEndNode.next.val) prevEndNode = prevEndNode.next;
        head = maxNode;
        while (head.next != null) {
            if (head.val < prevEndNode.val) {
                head.val = head.next.val;
                head.next = head.next.next;
            } else head = head.next;
        }
        return maxNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5,
                new ListNode(2,
                        new ListNode(13,
                                new ListNode(10,
                                        new ListNode(9,
                                                new ListNode(6,
                                                        new ListNode(8,
                                                                new ListNode(5,
                                                                        new ListNode(10,
                                                                                new ListNode(1,
                                                                                        null))))))))));
       /* ListNode head = new ListNode(5,
                new ListNode(2,
                        new ListNode(13,
                                new ListNode(3,
                                        new ListNode(8,
                                                null)))));*/
        System.out.println(printList(removeNodes(head)));
    }


    public static String printList(ListNode head) {

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) sb.append("->");
            else break;
        }
        return sb.toString();
    }
}