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
​
using Node = ListNode;
​
class Solution {
public:
    ListNode* reverseList(ListNode* root) {
        if(root == NULL or root->next == NULL){
            return root;
        }
        Node* nroot = reverseList(root->next);
        root->next->next = root;
        root->next = NULL;
        return nroot;
    }
};
