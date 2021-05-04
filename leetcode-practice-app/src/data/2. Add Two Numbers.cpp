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
    ListNode* addTwoNumbers(ListNode* root1, ListNode* root2) {
        if(!root1) {
            return root2;
        }
        if(!root2) {
            return root1 ;
        }
        ListNode *answer = NULL, *t, *prev(NULL) ;
        int cursum = 0, carry = 0 ;
        while(root1 or root2) {
            cursum = carry + ( root1 ? root1->val : 0 ) + ( root2 ? root2->val : 0 ) ;
            carry = (cursum > 9) ? 1 : 0 ;
            cursum %= 10 ;
            t = new ListNode(cursum) ;
            if(!answer) { answer = t ; }
            else {
                prev->next = t ;
            }
            prev = t ;
            if(root1) { root1 = root1->next ; }
            if(root2) { root2 = root2->next ; }
        }
        if(carry > 0) {
