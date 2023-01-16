import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while (n-- > 0) {
            if (pq.size() == 0) break;
            
            int temp = pq.poll();
            if (temp > 0) pq.offer(temp - 1);
        }
        
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            answer += temp * temp;
        }
        
        return answer;
    }
}