class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // Save the next node
            ListNode next = curr.next;

            // Reverse the pointer
            curr.next = prev;

            // Move prev and curr forward
            prev = curr;
            curr = next;
        }

        return prev;
    }
}