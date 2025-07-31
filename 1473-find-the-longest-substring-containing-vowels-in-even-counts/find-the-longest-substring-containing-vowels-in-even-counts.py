class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        """find the longest substring, containing each vowels even times"""
        # even numbers could be 0 also
        # question is substring -> 0...K (apply the dynamic sliding window)
        # How?: some kind of bit if it is present, we could easily find the last appeared index
        # this contains my vowels and some parity value to check in my hashmap
        vowels_map = dict(zip('aeiou', range(5)))
        
        # current on going mask
        current_mask=0 # default value is 0
        max_length=0 # default value is 0, nothing is available

        # mask to visited
        seen_index={0: -1}

        # iterate over the string, check if the char is a vowel
        for i, char in enumerate(s):
            if char in vowels_map:
                # get the parity from the vowels_map
                parity=vowels_map[char]
                # do some xor operation on the current map
                current_mask = current_mask ^ (1 << parity)
            # update the seen map
            if current_mask in seen_index:
                # check if the index is longer
                window=i-seen_index[current_mask]
                max_length=max(max_length, window)
            else:
                seen_index[current_mask]=i # current ith index

        return max_length
            