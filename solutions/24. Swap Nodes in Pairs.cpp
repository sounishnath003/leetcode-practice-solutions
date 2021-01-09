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
    ListNode* swapPairs(ListNode* head) {
        ListNode* extra = new ListNode();
        extra->next = head;
        f(extra);
        return extra->next;
    }
    void f (ListNode* root) {
        if (!root) {
            return ;
        }
        ListNode* first = root->next;
        ListNode* second = nullptr;
        if (first) {
            second = first->next;
        }
        if (second) {
            ListNode* snext = second->next;
            second->next = first ;
            root->next = second;
            first->next = snext; 
            f(first);
        }
    }
};
