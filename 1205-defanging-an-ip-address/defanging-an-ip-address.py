class Solution:
    def defangIPaddr(self, address: str) -> str:
        adds = address.split(".")
        
        # res = []
        # for i, add in enumerate(adds):
        #     res.append(add)
        #     if i < n - 1:
        #         res.append("[.]")

        return "[.]".join(adds)