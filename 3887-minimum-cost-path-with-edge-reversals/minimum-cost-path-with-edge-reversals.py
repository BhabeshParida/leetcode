from typing import List
import heapq

class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        # Build transformed graph
        graph = [[] for _ in range(n)]
        
        for u, v, w in edges:
            graph[u].append((v, w))        # normal edge
            graph[v].append((u, 2 * w))    # reversed edge using switch
        
        # Dijkstra
        dist = [float('inf')] * n
        dist[0] = 0
        pq = [(0, 0)]  # (cost, node)
        
        while pq:
            cost, u = heapq.heappop(pq)
            
            if cost > dist[u]:
                continue
            
            for v, w in graph[u]:
                if dist[v] > cost + w:
                    dist[v] = cost + w
                    heapq.heappush(pq, (dist[v], v))
        
        return -1 if dist[n - 1] == float('inf') else dist[n - 1]
