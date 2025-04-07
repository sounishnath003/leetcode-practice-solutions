class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        n = len(buildings)

        if n == 0:
            return []

        if n == 1:
            left, right, height = buildings[0]
            return [[left, height], [right, 0]]

        def merge(left: List[List[int]], right: List[List[int]]) -> List[List[int]]:
            lefty = 0
            righty = 0
            li = 0 
            ri = 0
            result = []

            def add(result, x, height):
                if not result or result[-1][0] != x:
                    if not result or result[-1][1] != height:
                        result.append([x, height])
                else:
                    result[-1][1] = height

            while li < len(left) and ri < len(right):
                if left[li][0] < right[ri][0]:
                    x = left[li][0]
                    lefty = left[li][1]
                    li += 1
                else:
                    x = right[ri][0]
                    righty = right[ri][1]
                    ri += 1
                add(result, x, max(lefty, righty))

            while li < len(left):
                add(result, left[li][0], left[li][1])
                li += 1

            while ri < len(right):
                add(result, right[ri][0], right[ri][1])
                ri += 1

            return result

        mid = n // 2
        left = self.getSkyline(buildings[:mid])
        right = self.getSkyline(buildings[mid:])

        return merge(left, right)