import heapq

"""
How it works:
Put every worker into a Min-Heap.Each entry in the heap will store: (time_when_next_unit_is_finished, worker_base_time, number_of_units_already_done).
In each step, "pop" the worker who finishes their next unit earliest.
Update their "next finish time" and push them back into the heap.Repeat this mountainHeight times.
"""

class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: list[int]) -> int:
        # Heap stores: (time_of_next_unit, base_worker_time, units_done_so_far)
        # The cost of the (k+1)-th unit is: base_time * (k + 1)
        pq = []
        for wt in workerTimes:
            # First unit (k=0) costs wt * (0 + 1)
            heapq.heappush(pq, (wt, wt, 1))
            
        max_time = 0
        for _ in range(mountainHeight):
            finish_time, base_time, units_done = heapq.heappop(pq)
            
            # This is the total time this specific worker has spent so far
            max_time = finish_time
            
            # Calculate when this same worker will finish their NEXT unit
            # Next unit is (units_done + 1)
            # Time cost for next unit = base_time * (units_done + 1)
            next_unit_finish_time = finish_time + (base_time * (units_done + 1))
            
            heapq.heappush(pq, (next_unit_finish_time, base_time, units_done + 1))
            
        return max_time
