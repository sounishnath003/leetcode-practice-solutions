class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        def is_palindrome(s,l,r) -> bool:
            while l<r:
                if s[l] != s[r]:
                    return False
                l+=1
                r-=1
            return True
        
        def check(a,b) -> bool:
            l,r=0,len(a)-1
            while l < r:
                if a[l]==b[r]:
                    l+=1
                    r-=1
                else:
                    return is_palindrome(a,l,r) or is_palindrome(b,l,r)
        
            return True
        
        return check(a,b) or check(b,a)

    def checkPalindromeFormation2(self, a: str, b: str) -> bool:
        def isPalindrome(s):
            return s == s[::-1]

        n = len(a)
        for i in range(n + 1):
            # a prefix + b suffix
            if isPalindrome(a[:i] + b[i:]):
                return True
            # b prefix + a suffix
            if isPalindrome(b[:i] + a[i:]):
                return True
        return False
