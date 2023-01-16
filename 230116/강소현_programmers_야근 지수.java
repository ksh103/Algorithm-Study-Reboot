import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        // 우선순위 큐에 들어온 값 중 큰 값이 우선
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        
        for(int work : works) {
            pq.offer(work); // 우선순위 큐에 담음
            sum += work; // 남은 작업량 합
        }
        
        // 퇴근까지 남은 n시간 >= 남은 작업량
        // 야근을 하지 않으므로 야근 피로도 0
        if(n >= sum) return 0;
        
        while(n != 0) {
            int workCheck = pq.poll(); // 일의 작업량 많이 남은 거 우선적으로 처리
            pq.offer(--workCheck);
            n--; // 남은 시간 감소
        }
        
        long answer = 0;
        for(int p : pq) {
            // 야근 피로도
            answer += Math.pow(p, 2);
        }
        
        return answer;
    }
}