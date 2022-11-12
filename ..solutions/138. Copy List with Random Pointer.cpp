/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
​
class Solution {
public:
   Node* copyRandomList(Node* head) {
   unordered_map<Node*, Node*> cache;
    Node* r = head;
    while(r) {
        cache[r] = new Node(r->val);
        r = r->next ;
    }
    r = head;
    while(r){
        cache[r]->next = cache[r->next];
        cache[r]->random = cache[r->random];
        r = r -> next;
    }
    return cache[head];
    }
};
