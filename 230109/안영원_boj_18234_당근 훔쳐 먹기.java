import java.io.*;
import java.util.*;

public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		PriorityQueue<Field> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long w = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());

			pq.offer(new Field(w, p));
		}

		// 최대한 묵혔다가 T - N 일 때 부터 먹기 시작
		long max = 0;
		for (int i = T - N; i < T; i++) {
			Field field = pq.poll();
			max += field.w + field.p * i;
		}

		System.out.println(max);
	}

	static class Field implements Comparable<Field> {
		long w;
		long p;

		Field (long w, long p) {
			this.w = w;
			this.p = p;
		}

		// 최대 성장치가 더 낮은 것을 앞에 배치(먼저 먹을 것)
		@Override
		public int compareTo(Field o) {
			long a = w + p * T;
			long b = o.w + o.p * T;

			return Long.compare(a, b);
		}
	}
}