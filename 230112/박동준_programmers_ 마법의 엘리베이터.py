def solution(storey):
    answer = 0
    check = False
    for i in range(len(str(storey))-1,-1,-1):
        num = int(str(storey)[i])
        if check:
            num += 1
        if num > 5:
            answer += 10 - num
            check = True
        elif num < 5:
            answer += num
            check = False
        else:
            answer += 5
            if i-1 >= 0 and int(str(storey)[i-1]) >=5:
                
                check = True
            else:
                check = False
            
        # print(num, str(storey)[i],str(storey)[i-1], str(storey)[i-1] == True,'answer',check, answer)        
    if check:
        answer += 1
    
    return answer