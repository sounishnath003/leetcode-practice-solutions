class Solution {
public:
    bool canPlaceFlowers(vector<int>& fruits, int n) {
        int l = (int) fruits.size();
        int count=0;
        for(int i = 0; i < l; i++) {
           if(fruits[i] == 0) {
                int prev= (i==0 || fruits[i-1] == 0) ? 0 : 1 ;
                int next= (i==l-1 || fruits[i+1] == 0) ? 0 : 1 ;
                if(prev==0 && next==0) {
                    fruits[i]=1;
                    count++;
                }
           }
        }
        return (count >= n);
    }
};
