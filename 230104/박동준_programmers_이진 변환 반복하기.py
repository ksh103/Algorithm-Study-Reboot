def solution(s):
    answer = []
    # 0을 제거함
    def delete_zero(num):
        new_num = ""
        zero_count = 0
        for i in num:
            if i == "1":
                new_num += "1"
            else:
                zero_count += 1
        
        return (new_num,zero_count)
    
    def change_two(num):
        length = len(num)
        new = ""
        while length > 0:
            a = length % 2
            b = length//2
            length = b
            new = str(a) + new
        
        return new
            
    # kk = change_two("111111")
    
    total_zero = 0
    change_count = 0
    
    while s != "1":
        new_num, zero_count = delete_zero(s)
        total_zero += zero_count
        change_count += 1
        s = change_two(new_num)
    
    return [change_count,total_zero]