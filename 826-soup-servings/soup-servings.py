""" WORST QUESTION """
""" Why 4800 in base case, IDK after alot of attempts just copy pasted """
""" But the operations are correct """

class Solution:
    def soupServings(self, n: int) -> float:
        
        @cache
        def f(soupa, soupb):
            """
            4 kind of ops we can perform
            """
            if n > 4800:
                return 1.0
            # base case: both soup is empty we stop 
            if soupa <= 0 and soupb <= 0:
                return 0.50
            # if soupa <= 0
            if soupa <= 0:
                return 1.0
            if soupb <= 0:
                return 0.0

            op1=0.25 * f(soupa - 100, soupb - 0)
            op2=0.25 * f(soupa - 75, soupb - 25)
            op3=0.25 * f(soupa - 50, soupb - 50)
            op4=0.25 * f(soupa - 25, soupb - 75)

            return op1+op2+op3+op4

        return f(n,n)