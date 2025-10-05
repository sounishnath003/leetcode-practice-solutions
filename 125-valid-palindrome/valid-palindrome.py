class Solution:
    def isPalindrome(self, s: str) -> bool:
        # just ignore non alphabetic characters
        left = 0
        right = len(s) - 1
        s = s.lower()

        while left <= right:
            # apply ignore non alphabetic characters
            if not s[left].isalnum():
                left += 1
                continue

            if not s[right].isalnum():
                right -= 1
                continue

            if s[left] != s[right]:
                return False

            left += 1
            right -= 1

        return True