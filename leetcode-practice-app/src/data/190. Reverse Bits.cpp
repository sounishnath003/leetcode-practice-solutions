class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
          // you need treat n as an unsigned value
   int res = 0;
        int x = 31;
        while(x >= 0){
            res = res ^ ((n & 0x1) << (x--));
            n >>= 0x1;
        }
​
        return res;
    }
};
