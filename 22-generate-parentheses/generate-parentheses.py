class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        @lru_cache(None)
        def fn(open_bracket:int, close_bracket: int, sequence:str) -> None:
            nonlocal n, res
            if open_bracket > n or len(sequence) > 2*n: return

            if len(sequence) == 2 * n:
                res.append(sequence)
                return

            fn(open_bracket+1, close_bracket, sequence+'(')
            if open_bracket > close_bracket:
                fn(open_bracket, close_bracket+1, sequence+')')


        fn(0,0,"")

        return res