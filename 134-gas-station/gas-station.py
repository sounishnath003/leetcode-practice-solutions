class Solution:
    def canCompleteCircuit(self, gas: list[int], cost: list[int]) -> int:
        """
        You can only do the tour if the surplus of GAS > 0
        Iterate over the array and start counting the left over gas; At any POT; you encounter
        currGas < 0: update possible start index to i+1 and currGas reset to 0
        Return the start point ones again as result
        """
        
        # corner gas; if total cost > total gas
        total_gas, total_cost = sum(gas), sum(cost)
        if total_cost > total_gas: return -1
        
        curr_gas = 0
        possible_start = 0
        for i, (g, c) in enumerate(zip(gas, cost)):
            curr_gas += (g - c)
            if curr_gas < 0:
                possible_start = i+1
                curr_gas = 0

        return possible_start if curr_gas >= 0 else -1
    