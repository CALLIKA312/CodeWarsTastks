package LeetCode.Daily.DeleteNodeinaLinkedList;

class Solution {
    public static void deleteNode(ListNode node) {
        ListNode prev;
        ListNode cur = node;
        ListNode next = node.next;
        int nextVal = next.val;
        while (true) {
            prev = cur;
            cur.val = nextVal;
            cur = next;
            next = cur.next;
            if (next != null) nextVal = next.val;
            else break;
        }
        prev.next = null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        deleteNode(node.next);
    }
}