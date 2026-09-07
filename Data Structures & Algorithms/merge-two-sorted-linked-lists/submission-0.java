class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node makes handling the head easier
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Compare nodes from both lists
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        // Attach whichever list is remaining
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}