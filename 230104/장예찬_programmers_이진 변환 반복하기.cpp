// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 예상 알고리즘: 구현
// 베스트 알고리즘: 구현

#include <algorithm>
#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(string s) {
    int count = 0, zero_deleted_count=0;
    while(s != "1"){
        int before_length = s.length();
        s.erase(remove(s.begin(), s.end(), '0'), s.end());
        int after_length = s.length();
        zero_deleted_count += before_length - after_length;
        count +=1;
        // s를 이진수로 표현
        s = "";
        while(after_length > 0){
            if (after_length % 2 == 0) s += "0";
            else s += "1";
            after_length /= 2;
        }
    }
    return {count, zero_deleted_count};
}

int main(){
    vector<int> answer = solution("110010101001");
    cout << answer[0]<<" "<<answer[1];
}