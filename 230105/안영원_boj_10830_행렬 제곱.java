import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] procession;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		procession = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				procession[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}

		int[][] result = pow(procession, b);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] pow (int[][] a, long b) {
		// 1제곱이라면 바로 종료
		if (b == 1L) return a;

		// 분할 정복으로 지수를 절반하여 값을 구함
		int[][] result = pow(a, b / 2);

		// 절반해줬기 때문에 얻은 값을 제곱해줌
		result = multiply(result, result);

		// 지수가 홀수라면 기존 행렬을 한 번 더 곱해준다
		if (b % 2 == 1L) result = multiply(result, procession);

		return result;
	}

	// 행렬을 곱해주는 용도
	static int[][] multiply(int[][] a, int[][] b) {
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					result[i][j] += a[i][k] * b[k][j];
					result[i][j] %= 1000;
				}
			}
		}

		return result;
	}
}