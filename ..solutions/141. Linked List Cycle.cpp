/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        set<ListNode*> cache ;
        while(head){
            if(cache.count(head)){
                return true;
            }
            cache.insert(head);
            head = head-> next;
        }
        return false;
    }
};
