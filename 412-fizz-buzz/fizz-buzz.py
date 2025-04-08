class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        results=[]

        while n > 0:
            if n % 15 == 0:
                results.append("FizzBuzz")
            elif n % 5 == 0:
                results.append("Buzz")
            elif n % 3 == 0:
                results.append("Fizz")
            else:
                results.append(str(n))

            n -=1

        return results[::-1]