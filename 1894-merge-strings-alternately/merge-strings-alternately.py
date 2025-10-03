class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n1=len(word1)
        n2=len(word2)
        max_len=max(n1,n2)
        answer = []
        for i in range(max_len):
            if i < n1:
                answer.append(word1[i])
            if i < n2:
                answer.append(word2[i])

        return ''.join(answer)
