# https://www.acmicpc.net/problem/14502
# 예상 알고리즘: BFS, 조합
# 베스트 알고리즘:

import sys
input = sys.stdin.readline

def solutionInput():
    N, M = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(N)]
    return N, M, board

drc = [(1,0),(-1,0), (0,1),(0,-1)]
def bfs(queue, board, zeroCnt, N, M):
    while queue:
        nextQueue = []
        for r, c in queue:
            for dr, dc in drc:
                nr = r + dr
                nc = c + dc
                if 0 <= nr < N and 0 <= nc < M and board[nr][nc] == 0:
                    nextQueue.append((nr, nc))
                    board[nr][nc] = 2
                    zeroCnt -= 1
        queue = nextQueue
    return zeroCnt

from itertools import combinations
def solution(N,M,board):
    answer = 0
    comb = []
    coronas = []
    zeroCnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                comb.append((i, j))
                zeroCnt += 1
            elif board[i][j] == 2:
                coronas.append((i, j))
    for walls in list(combinations(comb, 3)):
        tempBoard = [[i for i in b] for b in board] # copy
        for r, c in walls:
            tempBoard[r][c] = 1
        answer = max(answer, bfs(list(coronas), tempBoard, zeroCnt-3, N, M))

    return answer

print(solution(*solutionInput()))