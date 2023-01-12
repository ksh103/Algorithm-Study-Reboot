N,T = map(int, input().split())
arr = []
for i in range(N):
    # 맛과 영양제의 쌍
    w,p = map(int, input().split())
    arr.append((w,p))

arr.sort(key= lambda x : (x[1],x[0]))
answer = 0
for i in range(N):
    a = T-N+i
    answer += arr[i][0] + arr[i][1]*a

print(answer)