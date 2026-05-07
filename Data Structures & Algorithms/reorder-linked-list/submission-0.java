/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
        while (head != null && head.next != null) {

            ListNode tail = remove(head);
            ListNode nextHead = head.next;
            head.next = tail;
            tail.next = nextHead;
            head = nextHead;
        }

    }

    private ListNode remove(ListNode head) {

        if (head == null) return null;

        ListNode prev = head;

        while (head.next != null) {

            prev = head;
            head = head.next;
        }

        prev.next = null;
        return head;
    }
}
