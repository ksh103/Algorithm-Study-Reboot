import java.util.*;

class Solution {
    static int length;
    
    public int solution(int storey) {
        // 자리별로 나누기
        int[] jare = new int[9];
        length = Integer.toString(storey).length() - 1;
        int div = (int) Math.pow(10, length);
        
        int idx = 0;
        while (div != 0) {
            jare[idx] = storey / div;
            storey %= div;
            
            div /= 10;
            idx += 1;
        }
        
        
        // 5를 올리는 경우
		int[] temp = new int[9];
		for (int i = 0; i < 9; i++) temp[i] = jare[i];
		int a = fiveUp(temp);


		// 5를 내리는 경우
        for (int i = 0; i < 9; i++) temp[i] = jare[i];
		int b = fiveDown(temp);
        
        return Math.min(a, b);
	}

	static int fiveUp(int[] jare) {
		int answer = 0;

		for (int i = length; i > 0; i--) {
            double temp = (double) jare[i] / 10;
            
            // 내림일 때
            if (Math.round(temp) == 0) {
                answer += jare[i];
            // 올림일 때
            } else {
                answer += 10 - jare[i];
                
                // 이후 자리수들 정리
                jare = jungre(i - 1, jare);
            }
        }
        
		if (jare[0] == 10) answer += 1;
		else {
			double temp = (double) jare[0] / 10;
	
			// 내림일 때
			if (Math.round(temp) == 0) {
				answer += jare[0];
			// 올림일 때
			} else {
				answer += 10 - jare[0];
				answer += 1;
			}
		}

		return answer;
	}

	static int fiveDown(int[] jare) {
		int answer = 0;

		for (int i = length; i > 0; i--) {
            double temp = (double) jare[i] / 10;
            
            // 내림일 때
            if (Math.round(temp) == 0 || temp == 0.5) {
                answer += jare[i];
            // 올림일 때
            } else {
                answer += 10 - jare[i];
                
                // 이후 자리수들 정리
                jare = jungre(i - 1, jare);
            }
        }
        
		if (jare[0] == 10) answer += 1;
		else {
			double temp = (double) jare[0] / 10;
	
			// 내림일 때
			if (Math.round(temp) == 0 || temp == 0.5) {
				answer += jare[0];
			// 올림일 때
			} else {
				answer += 10 - jare[0];
				answer += 1;
			}
		}

		return answer;
	}

	static int[] jungre(int idx, int[] jare) {
        jare[idx] += 1;
        for (int i = idx; i > 0; i--) {
            if (jare[i] == 10) {
                jare[i] = 0;
                jare[i - 1] += 1;
            }
        }

		return jare;
    }
}