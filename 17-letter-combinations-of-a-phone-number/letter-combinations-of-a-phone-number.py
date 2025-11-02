class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        digit_map = {
        "1": ".", "2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno",
        "7": "pqrs", "8": "tuv", "9": "wxyz"
        }

        res = []

        def fn(i, ans: str) -> None:
            nonlocal digit_map
            if i == len(digits):
                res.append(ans)
                return

            for opt in digit_map[digits[i]]:
                fn(i+1, ans + opt)

        fn(0,"")
        return res
