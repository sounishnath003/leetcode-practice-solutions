/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */func oddEvenList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    
    
    second := head.Next
    
    tmp := head
    odd := head
    even := head.Next
    count := 1
    
    for tmp != nil {
        if count % 2 != 0 && tmp != head {
            odd.Next = tmp
            odd = tmp
        } 
        if count % 2 == 0 && tmp != second {
            even.Next = tmp
            even = tmp
        }
        tmp = tmp.Next
        count += 1
    }
    
    even.Next = nil
    odd.Next = second
    
    return head
}
