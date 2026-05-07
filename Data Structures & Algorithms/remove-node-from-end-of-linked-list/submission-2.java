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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = getLength(head);

        if (len == n) return head.next;

        ListNode temp = head;

        while (--len > n) {

            temp = temp.next;
            // System.out.println(temp.val);
        }

        temp.next = temp.next.next;
        return head;
    }

    private int getLength(ListNode head) {

        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}
