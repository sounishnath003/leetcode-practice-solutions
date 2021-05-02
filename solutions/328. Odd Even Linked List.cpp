using Node = ListNode;
class Solution {
public:
    ListNode* oddEvenList(ListNode* root) {
        if (root == nullptr || root->next == nullptr) {
            return root;
        }
        Node *even = nullptr, *odd = nullptr, *tmp = root;
        Node* t = nullptr, *p = nullptr; int c = 1;
        while(tmp != nullptr) {
            if (c & 1) {
                if (odd == nullptr) {
                    odd = new Node(tmp->val);
                    t = odd;
                } else {
                    Node *newnode = new Node(tmp->val);
                    odd->next = newnode;
                    odd = newnode;
                }
            } else {
                if (even == nullptr) {
                    even = new Node(tmp->val);
                    p = even;
                }else {
                    Node *newnode = new Node(tmp->val);
                    even->next = newnode;
                    even = newnode;
                }
            }
            tmp = tmp->next;
            c++;
        }
        odd->next = p;
        root = t;
        return root;
    }
};
