class Solution2:
    def longestAwesome(self, s: str) -> int:
        """
        awesome substring is as follows:
        non empty i.e. make any # of swaps in order to make it palindrome

        3242415
        24241

        -> we can may be start from middle and check both sides if it is palindrome
        store it's length and compare with gmax length
        """


# LC: 1542
# https://leetcode.com/problems/find-longest-awesome-substring/

class Solution:
    def longestAwesome(self, s: str) -> int:
        # get the length
        n=len(s)
        maxlength=1
        # find the largest window has the most even number of occurence and 1 even bits or (even counts)
        # ODD -> all evens # + 1. ODD count
        # EVEN -> all evens count

        bitsmasks={0: -1}
        mask=0

        for i, c in enumerate(s):
            digit=int(c)
            mask=mask ^ (1 << digit)
            if mask in bitsmasks:
                maxlength=max(maxlength, i - bitsmasks[mask])
            else:
                bitsmasks[mask]=i

            for d in range(0,10):
                nmask=mask ^ (1 << d)
                if nmask in bitsmasks:
                    maxlength=max(maxlength, i - bitsmasks[nmask])


        return maxlength