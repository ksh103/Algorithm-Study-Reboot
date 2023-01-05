# https://www.acmicpc.net/problem/1912
# 예상 알고리즘: DP, 슬라이딩 윈도우?
# 베스트 알고리즘: DP

import sys
input = sys.stdin.readline

def solutionInput():
    n = int(input().rstrip())
    numbers = list(map(int, input().split()))
    return n, numbers

def solution(n, numbers):
    dp = numbers[0]
    answer = numbers[0]
    for i in range(1, n):
        dp = max(dp+numbers[i], numbers[i])
        answer = max(answer, dp)
    return answer

print(solution(*solutionInput()))