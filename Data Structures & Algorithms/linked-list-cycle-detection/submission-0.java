/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        
        ListNode start = head;
        ListNode fast = start.next;

        while(start != null) {

            if (start == fast) {

                return true;
            }

            fast = fast.next;

            if (fast == null) return false;
            fast = fast.next;
            start = start.next;
        }

        return false;
    }
}
