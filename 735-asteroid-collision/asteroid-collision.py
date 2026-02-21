class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for asteroid in asteroids:
            if asteroid > 0:
                stack.append(asteroid)
            else:
                # positive
                while stack and stack[-1] > 0 and stack[-1] < -asteroid:
                    stack.pop()
                # equal size
                if stack and stack[-1] == -asteroid:
                    stack.pop()
                # stack empty or top asteroid is negetive
                elif not stack or stack[-1] < 0:
                    stack.append(asteroid)
                    
        return stack