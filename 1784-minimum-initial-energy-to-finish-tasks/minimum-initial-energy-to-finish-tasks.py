class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda p: p[1] - p[0]) # minimum - actual
        energy = 0

        for actual, minimum in tasks:
            energy = max(minimum, energy + actual)

        return energy
