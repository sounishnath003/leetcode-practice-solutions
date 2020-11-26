class Solution {
public:
void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
    int i=0,j=0,k=0;
    while (j<n && i<=(m+n) ){
        if(i>=(m+j)){ 
            nums1[i]=nums2[j];
            j++;
        } 
        else if(nums1[i]>=nums2[j]) {
            nums1.erase(nums1.begin()+m+k);
            nums1.insert(nums1.begin()+i,nums2[j]);
            j++;
            k++;
        }
        i++;
        }
    }
};
