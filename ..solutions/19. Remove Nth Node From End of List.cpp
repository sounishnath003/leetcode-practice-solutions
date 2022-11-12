/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int k) {
        ListNode* root = new ListNode() ;
        root->next = head;
        ListNode* f = root, *s = root;
        for(int i = 1; i <= k+1; i++)
            f = f -> next;
        
        while(f){
            f = f -> next;
            s = s -> next;
        }
        ListNode* d = s->next;
        s->next = s->next->next;
        delete d;
        return root->next;
    }
};
