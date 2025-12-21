class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        cd1,cn1=None,0
        cd2,cn2=None,0
        
        for num in nums:
            if cd1 and cd1 == num:
                cn1 += 1
            elif cd2 and cd2 == num:
                cn2 += 1
            elif cn1 == 0:
                cd1,cn1=num,1
            elif cn2 == 0:
                cd2,cn2=num,1
            else:
                cn1-=1
                cn2-=1
                
        # print([cd1, cd2])
        res = []
        for pot in set([cd1,cd2]):
            if pot is not None and nums.count(pot) > len(nums) // 3: res.append(pot)
            
        return res