class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        freqmap = Counter(s)
        seen = set()
        
        for i, char in enumerate(s):
            # i will always reduce the count of characters from frequency map
            freqmap[char] -= 1
            # nothing to do here! :-0
            if char in seen:
                continue
                
            # i iwll make sure, it is lexiographically smaller than the cahracters on stack
            # i can only pop them, if the freqmap of the top element is bigger than 0 (its count)
            while stack and freqmap[stack[-1]] > 0 and stack[-1] > char:
                seen.remove(stack.pop())

			# add all the new characters
            stack.append(char)
            seen.add(char)

        return ''.join(stack)