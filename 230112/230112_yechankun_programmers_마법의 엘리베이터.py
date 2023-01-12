# https://school.programmers.co.kr/learn/courses/30/lessons/148653
# 예상 알고리즘: DP, 구현
# 베스트 알고리즘: 수학, 그리디

def solution(storey):
    answer = 0
    while storey:
        remain = storey % 10
        storey //= 10
        if remain < 5:
            answer += remain
        elif remain > 5:
            storey += 1
            answer += 10 - remain
        else: #5의 경우
            if storey % 10 > 4:
                storey += 1  
            answer += 5
    return answer

print(solution(16)) # 6
print(solution(45)) # 

print(solution(2554)) # 16