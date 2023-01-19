import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 정렬된 사전 단어와 존재하는 단어 개수
		Map<String, Integer> dictMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String word = makeWord(br.readLine());
			
			if (dictMap.containsKey(word)) {
				dictMap.put(word, dictMap.get(word) + 1);
			} else dictMap.put(word, 1);
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] words = br.readLine().split(" ");

			int cnt = 0;
			for (int j = 0; j < words.length; j++) {
				String word = makeWord(words[j]);

				if (dictMap.containsKey(word)) {
					if (j == 0) cnt = dictMap.get(word);
					else cnt *= dictMap.get(word);
				}
			}

			sb.append(cnt + "\n");
		}

		System.out.println(sb);
	}

	// 정렬된 모양의 단어로 만들기
	static String makeWord(String word) {
		// 단어의 길이가 1인 경우 예외 처리
		if (word.length() == 1) return word;

		// 첫 글자와 끝 글자 그리고 나머지 뽑기
		String first = word.substring(0, 1);
		String last = word.substring(word.length() - 1);
		String temp = word.substring(1, word.length() - 1);

		// 정렬시키기
		temp = Stream.of(temp.split("")).sorted().collect(Collectors.joining());

		// 합치고 사전맵에 넣기
		word = first + last + temp;

		return word;
	}
}