class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int cnt = 0;
        
        while (!s.equals("1")) {
            cnt += 1;
            String temp = "";
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt += 1;
                } else {
                    temp += s.charAt(i);
                }
            }
            
            s = Integer.toBinaryString(temp.length());
        }
        
        answer[0] = cnt;
        answer[1] = zeroCnt;
        return answer;
    }
}