class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # 1. Find the middle
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # 2. Split and reverse the second half
        second = slow.next
        slow.next = None

        prev = None

        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp

        # prev is now the head of the reversed second half
        second = prev

        # 3. Merge the two halves
        first = head

        while second:
            temp1 = first.next
            temp2 = second.next

            first.next = second
            second.next = temp1

            first = temp1
            second = temp2