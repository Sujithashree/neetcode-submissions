class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None

        # Map original nodes to their copies
        oldToNew = {}

        # First pass: create all new nodes
        curr = head

        while curr:
            oldToNew[curr] = Node(curr.val)
            curr = curr.next

        # Second pass: connect next and random pointers
        curr = head

        while curr:
            oldToNew[curr].next = oldToNew.get(curr.next)
            oldToNew[curr].random = oldToNew.get(curr.random)
            curr = curr.next

        return oldToNew[head]