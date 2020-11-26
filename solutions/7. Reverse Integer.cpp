class Solution {
public:
    int reverse(int x) {
        int ret = 0;
        int last_digit = 0;
        while(true) {
            last_digit = x % 10;
            ret = ret + last_digit;
            x = x/10;
            if (x == 0) break;
            else {
                if (ret > INT_MAX/10 || ret < INT_MIN/10) return 0;
                ret = ret * 10;
            }
        }
        return ret;   
    }
};
