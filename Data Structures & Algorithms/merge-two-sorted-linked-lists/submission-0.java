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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode node = new ListNode(0);
        ListNode start = node;

        while (list1 != null && list2 != null) {

            ListNode temp;

            if ((list1 != null && list2 == null) || list1.val < list2.val) {

                temp = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                temp = new ListNode(list2.val);
                list2 = list2.next;
            }

            start.next = temp;
            start = start.next;
        }

        if (list1 != null) start.next = list1;
        if (list2 != null) start.next = list2;

        return node.next;
    }
}