package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 11509번 풍선 맞추기 */
public class boj_11509 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] balloons = new int[N];

        int maxHeight = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());

            maxHeight = maxHeight < balloons[i] ? balloons[i] : maxHeight;
        }

        int[] arrows = new int[maxHeight + 1];

        int count = 0;

        for (int b : balloons) {
            // 현재 높이에 화살이 있을 경우
            if (arrows[b] > 0) {
                arrows[b]--; // 풍선 터트리기
                arrows[b - 1]++; // 화살 높이 줄이기
            } else {
                arrows[b - 1]++; // 화살 높이 줄이기
                count++; // 필요한 화살 개수 카운트
            }
        }

        System.out.println(count);

    }
}
