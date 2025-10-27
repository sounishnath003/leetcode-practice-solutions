class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: return None
        dummy = ListNode()

        heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val, i, node)) # MIN HEAP

        curr = dummy
        while heap:
            val, i, node = heapq.heappop(heap)
            curr.next=node
            curr=node
            if node and node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))

        return dummy.next        