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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode node = new ListNode(0);
        ListNode start = node;

        while(true) {

            int minInd = -1;
            ListNode minNode = null;

            for (int i = 0;i < lists.length; i++) {

                ListNode curr = lists[i];

                if (curr == null) continue;

                if (minNode == null || curr.val < minNode.val) {
                    minNode = curr;
                    minInd = i;
                }
            }

            if (minNode == null) {
                return node.next;
            }
            start.next = new ListNode(minNode.val);
            start = start.next;
            lists[minInd] = lists[minInd].next;
        }

        // return node.next;
    }
}
