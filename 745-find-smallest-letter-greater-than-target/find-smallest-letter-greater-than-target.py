class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        def gid(c: str):
            return (ord(c) - ord('a'))

        ans = None
        gmin = 10**20
        for letter in letters:
            conditions = (
                gid(letter) > gid(target)
            )
            someid = gid(letter) - gid(target)
            if conditions and gmin > someid:
                ans = letter
                gmin = someid

        return letters[0] if ans is None else ans


