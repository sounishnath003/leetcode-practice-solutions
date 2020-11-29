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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        // set<ListNode*>  cache;
        // if(headA == NULL or headB == NULL){
        //     return NULL;
        // }
        // while(headA != NULL){
        //     cache.insert(headA);
        //     headA = headA->next;
        // }
        // while(headB){
        //     if(cache.count(headB)){
        //         return headB;
        //     }
        //     headB = headB->next;
        // }
        // return NULL ;
        
          ListNode* pa = headA, *pb = headB;
        while (pa != pb) {
            if(pa!=NULL)
                pa = pa->next;
            else
                pa = headB;
            if(pb!=NULL)
                pb = pb->next;
            else
                pb = headA;
        }
        return pa;
    }
};
