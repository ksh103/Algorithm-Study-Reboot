import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken()); 
		}

		// dp는 현재 위치에서 가장 최대의 합을 표시
		int[] dp = new int[n];
		dp[0] = num[0];

		int answer = num[0];
		// 연속된 합이 커지면 커진 값을 기록, 아니면 현재 위치 값을 기록
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}