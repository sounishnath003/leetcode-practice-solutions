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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty()) {
            return nullptr;
        }
        ListNode* root = new ListNode(-1);
        ListNode* temp = root;
        while(1) {
            int curr = 0;
            for(int i = 0; i < lists.size(); i++) {
                if(lists[curr]==nullptr || (lists[i]!=nullptr && lists[curr]->val > lists[i]->val)) {
                    curr=i;
                }
            }
            if(lists[curr]==nullptr)
                break;
            temp->next = lists[curr];
            temp = temp->next;
            lists[curr]=lists[curr]->next;
        }
        return root->next;
    }
};
