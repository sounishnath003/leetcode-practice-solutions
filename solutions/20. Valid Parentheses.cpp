class Solution {
public:
   bool isValid(string s) {
        
        map<char,char> closing; // the set of closing parenthesis
        closing[')'] = '('; // the opening parenthesis of the closing parenthesis
        closing[']'] = '[';
        closing['}'] = '{';
        
        stack<char> stack;
        map<char,char>::iterator it;
        for (int i = 0; i < s.size(); i++)  {
            it = closing.find(s[i]);
            if (it != closing.end())     // if s[i] is found in closing
                if (!stack.empty() && it->second == stack.top())    // if stack is not empty and its top element is the opening parenthesis of the closing parenthesis s[i]
                    stack.pop();
                else
                    return false;
            else
                stack.push(s[i]);   // add the opening s[i] to stack
        }
                
        if (stack.empty())
            return true;
        else
            return false;
    }
};
