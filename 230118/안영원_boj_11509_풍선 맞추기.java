import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 날아가고 있는 화살을 HashMap을 통해 관리 -> 화살높이, 개수
		Map<Integer, Integer> arrowMap = new HashMap<>();
		int arrowCnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int balloonHeight = Integer.parseInt(st.nextToken());

			// 현재 풍선을 터뜨릴 수 있는 화살이 있다면
			if (arrowMap.containsKey(balloonHeight)) {
				int cnt = arrowMap.get(balloonHeight);
				
				// 현재 높이의 화살 개수 줄이고 
				if (cnt - 1 > 0) arrowMap.put(balloonHeight, cnt - 1);
				else arrowMap.remove(balloonHeight);

				// -1 높이의 화살 개수 늘림
				if (arrowMap.containsKey(balloonHeight - 1)) {
					arrowMap.put(balloonHeight - 1, arrowMap.get(balloonHeight - 1) + 1);
				} else arrowMap.put(balloonHeight - 1, 1);
			} else {
				// 화살 추가
				arrowCnt += 1;

				if (arrowMap.containsKey(balloonHeight - 1)) {
					arrowMap.put(balloonHeight - 1, arrowMap.get(balloonHeight - 1) + 1);
				} else arrowMap.put(balloonHeight - 1, 1);
			}
		}

		System.out.println(arrowCnt);
	}
}