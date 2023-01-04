n = int(input())
arr = list(map(int, input().split()))
dp = [0]*len(arr)
dp[0] = arr[0]
max_num = dp[0]
for i in range(1,len(arr)):
    dp[i] = max(dp[i-1] + arr[i], arr[i], arr[i] + arr[i-1])
    if max_num < dp[i]:
        max_num = dp[i]
print(max_num)
