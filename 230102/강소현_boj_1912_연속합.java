package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1912번 연속합 */
public class boj_1912 {

    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int sum = dp[0];

        for (int i = 1; i < N; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);
            } else {
                dp[i] += dp[i - 1];
            }
            sum = Math.max(sum, dp[i]);
        }

        System.out.println(sum);

    }
}
