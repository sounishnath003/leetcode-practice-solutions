class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        def is_valid(first,second,remaining):
            while remaining:
                next_num=str(int(first) + int(second))
                if not remaining.startswith(next_num):
                    return False
                first,second=second,next_num
                remaining=remaining[len(next_num):]
            return True

        # get the length first
        n=len(num)
        # split the number seq. in every possible gaps
        # Iterate through all possible splits of the string
        for i in range(1, n):  # `i` determines the end of the first number
            for j in range(i + 1, n):  # `j` determines the end of the second number
                first, second = num[:i], num[i:j]
                # Skip invalid numbers with leading zeros
                if (len(first) > 1 and first[0] == '0') or (len(second) > 1 and second[0] == '0'):
                    continue
                # Check if the sequence is valid starting with `first` and `second`
                if is_valid(first, second, num[j:]):
                    return True
        return False
