class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result=strs[0]
        
        # iterate over the strs
        for strr in strs[1:]:
            while not strr.startswith(result):
                result=result[:-1]
                if len(result)==0:
                    return ""
        
        return result