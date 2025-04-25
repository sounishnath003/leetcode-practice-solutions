class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        n = len(num)

        def is_valid(first, second, remaining):
            while remaining:
                next_num = str(int(first) + int(second))
                if not remaining.startswith(next_num):
                    return False
                first, second = second, next_num
                remaining = remaining[len(next_num):]
            return True

        for i in range(1, n):
            for j in range(i + 1, n):
                first, second = num[:i], num[i:j]
                if (len(first) > 1 and first[0] == '0') or (len(second) > 1 and second[0] == '0'):
                    continue
                if is_valid(first, second, num[j:]):
                    return True
        return False