# https://www.acmicpc.net/problem/18352
# 예상 알고리즘: 다익스트라
# 베스트 알고리즘: BFS

import sys
from collections import defaultdict
input = sys.stdin.readline

def solutionInput():
    N, M, K, X = map(int, input().split())
    cities = defaultdict(set)

    for i in range(M):
        start, dist = map(int, input().split())
        cities[start].add(dist)
    return N, M, K, X, cities

def solution(N, M, K, X, cities):
    visited = [False] * (N+1)
    dists = [float('inf') for _ in range(N+1)]
    visited[X], dists[X] = True, 0
    queue = [X]
    while queue:
        nextQueue = []
        for q in queue:
            for nextCity in cities[q]:
                if dists[q] + 1 < dists[nextCity]:
                    dists[nextCity] = dists[q] + 1
                if not visited[nextCity]:
                    nextQueue.append(nextCity)
                    visited[nextCity] = True
        queue = nextQueue
    return answer if (answer:= [idx for idx, d in enumerate(dists) if d == K]) else [-1]

for answer in solution(*solutionInput()):
    print(answer)
