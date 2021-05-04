class Solution {
public:
    int reachNumber(int n) {
        n = abs(n);
​
        int sum = 0, steps = 0;
        while(sum < n) {sum+=(steps++);}
        while ((sum-n) % 2 == 1) {
            sum+= (steps++);
        }
        return steps-1;
    }
};
