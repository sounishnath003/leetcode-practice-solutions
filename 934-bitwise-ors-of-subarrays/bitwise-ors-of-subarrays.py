class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        n = len(arr)
        distinct_ors = set()
        current_ors = set()

        for num in arr:
            new_ors = {num}
            for prev_or in current_ors:
                new_ors.add(prev_or | num)
            current_ors = new_ors
            distinct_ors.update(current_ors)

        return len(distinct_ors)
        
    def subarrayBitwiseORsSLOW(self, arr: List[int]) -> int:
        # get the length
        n=len(arr)
        # result all distinct subarray will get stored
        result=set()
        for start in range(n):
            orr=0
            for end in range(start, n):
                orr = orr | arr[end]
                if orr not in result:
                    result.add(orr)
        return len(result)