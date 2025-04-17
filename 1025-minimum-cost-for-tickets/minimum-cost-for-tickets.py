class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """ find the minimum spend dollars to travel everyday"""
        # define a dp for memoization
        dp = {}
        def minCost(days,i,dp):
            if i == len(days):
                return 0
            # if particular day already computed
            if i in dp:
                return dp[i]
            # at every day ith i have an option to travel or 
            # try out all possibilities
            min_cost=float("inf")
            for d,c in zip([1,7,30],costs):
                # now the thing is i+d has to be present in the array
                # and days will always be sorted
                current_day=i
                day_index=i
                # skip all the days which are coverred by the pass
                while day_index < len(days) and days[day_index] < days[current_day] + d:
                    # skip all the days which are coverred by the pass
                    day_index+=1
                # we need to minimize cost
                min_cost = min(min_cost, c + minCost(days,day_index,dp))
            
            dp[i]=min_cost
            # return the minimum cost i have incurred from this day
            return min_cost

        return minCost(days,0,dp)
