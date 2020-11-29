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
    ListNode* r = NULL;
    bool ans = true;
    
    void solve(ListNode* rt){
        if(rt == NULL){
            return ;
        }
        solve(rt->next);
        
        if(rt->val != r->val){
            ans = false;
            return;
        }
        r = r->next;
    }
    
    bool isPalindrome(ListNode* head) {
        // stack<int> cache;
        // ListNode* r = head;
        // while(r){
        //     cache.push(r->val);
        //     r = r->next;
        // }
        // r = head;
        // while(r){
        //     if(cache.top() != r->val){
        //         return false;
        //     }
        //     r = r->next;
        //     cache.pop();
        // }
        // return true;
        
        r = head;
        solve(head);
        return ans;
    }
};
