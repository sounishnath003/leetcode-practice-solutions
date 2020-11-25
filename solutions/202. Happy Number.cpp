class Solution {
public:
    bool isHappy(int n) {
        set<int> cache;
        while(!cache.count(n)){
            cache.insert(n);
            n = f(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }
    int f(int n) {
        int sum = 0;
        while(n > 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
};
