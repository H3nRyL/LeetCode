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
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for (ListNode l : lists) {
            if (l != null)
                q.add(l);
        }
        
        ListNode head = new ListNode(0);
        ListNode point = head;
        
        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null)
                q.add(next);
        }
        
        return head.next;
    }
}