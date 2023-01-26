# https://school.programmers.co.kr/learn/courses/30/lessons/42577
# 예상 알고리즘: 해시
# 베스트 알고리즘: 해시

def solution(phone_book):
    numberSet = set(phone_book)
    return  len([0 for number in phone_book for i in range(len(number)) if number[:i] in numberSet]) == 0


print(solution(["119", "97674223", "1195524421"])) # False
print(solution(["123", "456", "789"])) # True
print(solution(["113", "44", "4544"]))
print(solution(["11", "12"])) # False