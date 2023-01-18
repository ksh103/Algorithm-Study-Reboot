# https://school.programmers.co.kr/learn/courses/30/lessons/12927
# 예상 알고리즘: 수학, 우선순위 큐
# 베스트 알고리즘: 수학, 우선순위 큐

from heapq import heappush, heappop, heapify
# 수는 기하급수적으로 커지기 때문에 무조건 평탄하게 평균과 가까워지는 것이 가장 피로도가 최소화됨
def solution(n, works):
    works = list(map(lambda x: -x,works)) #내림차순인 우선순위 큐를 만들기 위함
    heapify(works) #우선순위 큐로 만듬
    while n > 0:
        if (works[0] == 0):
            break
        temp = heappop(works) + 1
        heappush(works, temp)
        n-=1
    answer = sum(map(lambda x: (-x)**2, works))
    return answer

print(solution(4, [4, 3, 3]))


print(solution(6, [12, 3, 4, 5, 3]))