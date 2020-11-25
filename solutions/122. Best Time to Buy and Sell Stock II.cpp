class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0)
            return 0;
​
        int sum = 0, prev = 0;
        for (int i = 0; i < prices.size(); i++)
        {
            if (i == prices.size() - 1)
            {
                sum += prices[i] - prices[prev];
            }
​
            else if (prices[i] > prices[i + 1])
            {
                sum += prices[i] - prices[prev];
                prev = i + 1;
            }
        }
​
        return sum;
    }
};
