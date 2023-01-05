#
# 예상 알고리즘: 분할정복
# 베스트 알고리즘: 분할정복
import sys
from collections import defaultdict
input = sys.stdin.readline

def solutionInput():
    N, B = map(int, input().split())
    arrays = [list(map(int, input().split())) for _ in range(N)]
    return N, arrays, B

# 수학 문제로 보인다.
# 분할 정복으로 문제풀이를 진행한다.
dp = defaultdict(list)

def solution(N, arrays, B):
    print(*[' '.join(map(str, answer)) for answer in matrixExp(N, arrays, B)], sep='\n')
    return

def matrixExp(N, arrays, i):
    if i in dp:
        return dp[i]
    if i == 1:
        return [list(map(lambda x: x%1000, number)) for number in arrays]
    elif i == 2:
        return quadratic(arrays, arrays)
    dp[i] = quadratic(matrixExp(N, arrays, i//2), matrixExp(N, arrays, i-i//2))
    return dp[i]

def quadratic(A, B):
    N = len(A)
    answer = [[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            for k in range(N):
                answer[i][j] += A[i][k]*B[k][j]
            answer[i][j] %= 1000
    return answer

solution(*solutionInput())