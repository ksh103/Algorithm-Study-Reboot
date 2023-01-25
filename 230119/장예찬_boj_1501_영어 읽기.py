# https://www.acmicpc.net/problem/1501
# 예상 알고리즘: 조합, 해시
# 베스트 알고리즘: 해시

import sys
inputs = sys.stdin.readline

def solutionInput():
    N = int(input())
    voca = [input() for _ in range(N)]
    M = int(input())
    sentences = [input() for _ in range(M)]

    return N, voca, M, sentences

from collections import Counter
def solution(N, voca, M, sentences):
    k = Counter([((v[0], v[-1]), tuple(sorted(Counter(v).most_common()))) for v in voca])
    answer = []
    for string in sentences:
        partAnswer = 1
        for s in string.split():
            sTuple = tuple(sorted(Counter(s).most_common()))
            key = ((s[0], s[-1]), sTuple)
            partAnswer *= k.get(key, 0)
        answer.append(partAnswer)
    return answer

print(*solution(*solutionInput()) , sep="\n")

