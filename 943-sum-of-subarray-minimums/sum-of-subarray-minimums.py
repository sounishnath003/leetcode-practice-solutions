class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        # define the MOD
        MOD = int(1e9+7)
        # get the length of the arr
        n=len(arr)
        # define the stack
        stack=[] # (index, curr_elem)
        # resultant sum of minimums
        result=0
        # iterate over the array
        for i in range(n):
            curr_elem=arr[i]
            # keep the minimum elements into the stack always
            while stack and curr_elem < stack[-1][1]:
                # pop the elem
                j,m=stack.pop()
                # so we have popped the i th elements
                # 1 2 3 4 5 1
                #.    j    i
                total_elements_in_right=i-j
                total_elements_in_left=j - stack[-1][0] if stack else j+1
                result = (result + (m * total_elements_in_left * total_elements_in_right)%MOD) % MOD
            # put the elemt into the stack
            stack.append((i,curr_elem))

        for i in range(len(stack)):
            j,m=stack[i]
            left=j-stack[i-1][0] if i>0 else j+1
            right=len(arr)-j

            result=(result+(m*left*right)%MOD) % MOD

        return result
