# https://www.acmicpc.net/problem/11509
# 예상 알고리즘: 그리디, 해시
# 베스트 알고리즘: 

import sys
input = sys.stdin.readline

def solutionInput():
    N = int(input())
    H = list(map(int, input().split()))

    return N, H

from collections import defaultdict

def solution(N, H):
    answer = 0
    arrowHeight = defaultdict(int)
    for i in range(N):
        if arrowHeight[H[i]] != 0:
            arrowHeight[H[i]] -= 1
        else:
            answer +=1
        arrowHeight[H[i]-1] += 1
    return answer

print(solution(*solutionInput()))