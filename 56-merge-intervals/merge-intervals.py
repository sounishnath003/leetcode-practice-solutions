class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # sort the input based on their start time
        intervals.sort(key=lambda interval: interval[0])
        # to store the merged intervals and return as result
        result = [intervals[0]] # empty box fixer as default value
        # what is the merging rule?
        # if previous end time > current start time -> merge them
        for current in intervals[1:]:
            if result[-1][1] >= current[0]:
                result[-1][1] = max(current[1], result[-1][1])
            else:
                result.append(current)

        return result
