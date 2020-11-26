struct Element
{
    int val;
    int min;
};
​
class MinStack
{
    stack<Element> m_data;
    int curr_min;
public:
    /** initialize your data structure here. */
    MinStack()
​
    void push(int x)
    {
        Element e;
        e.val = x;
        if( m_data.empty()){
            curr_min = INT32_MAX;
        }
        if( curr_min > x){
            curr_min = x;
        }
        e.min = curr_min;
        m_data.push(e);
    }
​
    void pop()
    {
        m_data.pop();
        if(!m_data.empty())
            curr_min = m_data.top().min;
    }
​
    int top()
