class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
       int n = digits.size();
        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        vector<int> nn(n + 1);
        nn[0] = 1;
        return nn;
    }
};
​
//1 2 3 9 9 9
 
