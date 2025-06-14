class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        max_requests=0
        movements=[0 for _ in range(n)]

        def backtrack(index, count):
            nonlocal max_requests
            nonlocal movements

            if index == len(requests):
                if all(d==0 for d in movements):
                    max_requests=max(max_requests, count)
                return
            
            # not pick
            backtrack(index+1, count)

            # pick
            fromm, to=requests[index]
            movements[fromm] -=1
            movements[to] +=1

            backtrack(index+1, count + 1)
            # backtrack
            movements[fromm] +=1
            movements[to] -=1


        backtrack(0,0)
        return max_requests