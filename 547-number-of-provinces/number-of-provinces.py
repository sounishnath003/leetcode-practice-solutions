# https://leetcode.com/problems/number-of-provinces/

from collections import defaultdict
from typing import List

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        """looks like we need to find the strongly connected components"""
        # get the length
        R=len(isConnected)
        C=len(isConnected[0])
        # total number of nodes
        NODES=R
        """to find the strongly-connected-components; 1. DFS(2-way kosaraju dfs)"""
        # create the adjancent list
        graph = defaultdict(list)
        for u in range(R):
            for v in range(C):
                if isConnected[u][v] == 1:
                    graph[u].append(v)
                    # graph[v].append(u)

        """find the DFS function"""
        def dfs1(graph,node,visited,topolist):
            # mark as visited the node
            visited.add(node)
            # explore all the nbr and perform dfs
            for nbr in graph[node]:
                if nbr not in visited:
                    dfs1(graph,nbr,visited,topolist)
            # add the node into the topological ordering
            topolist.append(node)
        
        topolist=[]
        visited=set()
        scc=0
        for node in range(NODES):
            if node not in visited:
                dfs1(graph,node,visited,topolist)
                # increment the ssc as what all the nodes were visited
                scc +=1

        # # ones the topological ordering is completed, 
        # # we need to count strong components using the dfs2 and reversing the links
        # # create a graph 2
        # graph2=defaultdict(list)
        # for u in range(R):
        #     for v in range(C):
        return scc