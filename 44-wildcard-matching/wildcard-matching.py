class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        memo = {}  # Memoization dictionary

        def solve(i, j):
            if (i, j) in memo:
                return memo[(i, j)]

            if j == len(p):
                result = i == len(s)
                memo[(i, j)] = result
                return result

            if i == len(s):
                if j < len(p) and p[j] == '*':
                    result = solve(i, j + 1)
                    memo[(i, j)] = result
                    return result
                else:
                    memo[(i,j)] = False
                    return False

            if p[j] == '*':
                result = solve(i + 1, j) or solve(i, j + 1)
                memo[(i, j)] = result
                return result
            elif p[j] == '?' or s[i] == p[j]:
                result = solve(i + 1, j + 1)
                memo[(i, j)] = result
                return result
            else:
                memo[(i, j)] = False
                return False

        return solve(0, 0)