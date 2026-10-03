class Solution:
    def addTwoNumbers(
        self,
        l1: Optional[ListNode],
        l2: Optional[ListNode]
    ) -> Optional[ListNode]:

        dummy = ListNode(0)
        curr = dummy
        carry = 0

        while l1 or l2 or carry:
            # Get current digits
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0

            # Add digits + carry
            total = x + y + carry

            # Current digit
            digit = total % 10

            # Carry for next position
            carry = total // 10

            # Create new node
            curr.next = ListNode(digit)
            curr = curr.next

            # Move forward
            if l1:
                l1 = l1.next

            if l2:
                l2 = l2.next

        return dummy.next