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
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode* root1 = nullptr;
    Solution(ListNode* head) {
        root1 = head;
    }
    
    /** Returns a random node's value. */
    int getRandom() {
        ListNode* root = root1;
        int i = 1, ans = 0;
        while(root) {
            if((float)(rand() / RAND_MAX) < 1.0/i ) {
                ans = root -> val;
            }
            i++;
            root = root -> next;
        }
        return ans;
    }
};
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(head);
 * int param_1 = obj->getRandom();
 */
