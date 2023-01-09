# https://www.acmicpc.net/problem/18234
# 예상 알고리즘: 그리디
# 베스트 알고리즘: 그리디

def solutionInput():
    N, T = map(int, input().split())

    carrots = [list(map(int, input().split())) for _ in range(N)]
    
    return N, T, carrots

def solution(N, T, carrots):
    answer = 0
    carrots.sort(key=lambda x: x[1])

    for day, data in enumerate(carrots, T-N):
        taste, nutrition = data
        answer += taste + nutrition*day
    return answer

print(solution(*solutionInput()))