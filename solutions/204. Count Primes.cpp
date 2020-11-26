class Solution {
public:
    int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        
        vector<bool> primee(n + 1) ;
        for(long long int i = 2; i < n + 1; i++){
            if(!primee[i]){
                for(long long int j = i * i; j < n + 1; j += i){
                    primee[j] = true;
                }
            }
        }
        
        int ans = 0;
        for(int i = 2; i < n ; i++){
            if(primee[i] == false){
                ans++;
            }
        }
        
        return ans;
    }
};
