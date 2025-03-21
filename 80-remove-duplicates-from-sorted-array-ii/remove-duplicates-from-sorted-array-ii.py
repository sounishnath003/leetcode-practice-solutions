class Solution:
    def removeDuplicates(self, arr: List[int]) -> int:
        n=len(arr)

        start=2
        for end in range(2, n):
            if arr[end] != arr[start-2]:
                arr[start]=arr[end]
                start +=1

        print("out=", arr)
        return start
