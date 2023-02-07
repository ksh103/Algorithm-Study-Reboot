# https://www.acmicpc.net/problem/21758
# 예상 알고리즘: DP
# 베스트 알고리즘: DP, 그리디

import sys
input = sys.stdin.readline

def solutionInput():
    N = int(input())
    places = list(map(int, input().split()))
    return N, places

def solution(N, places):
    forwardSum = [0] * len(places)
    reverseSum = [0] * len(places)
    for i in range(1, N):
        forwardSum[i] += forwardSum[i-1] + places[i-1]
        reverseSum[N-i-1] += reverseSum[N-i] + places[N-i]
    # 왼왼, 오오, 왼오 중 최대값을 구하면 됨
    answer = 0
    # 왼(맨 오른쪽은 벌꿀)
    for i in range(1, N-1):
        answer = max(reverseSum[0]-places[i]+reverseSum[i], answer)
    # 오(맨 왼쪽이 벌꿀)
    for i in range(N-2, 0, -1):
        answer = max(forwardSum[N-1]-places[i]+forwardSum[i], answer)

    # 왼오는 벌이 항상 양 끝임
    for i in range(1, N-1):
        answer = max(forwardSum[N-1]-forwardSum[i]+reverseSum[0]-reverseSum[i], answer)
    return answer


print(solution(*solutionInput()))
print(solution(7, [9, 9, 4, 1, 4, 9, 9]))
print(solution(7,[4, 4, 9, 1, 9, 4, 4]))
print(solution(3,[2, 5, 4]))
# print(solution())

