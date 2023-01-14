package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18352 {

    static int N, M, K, X;
    static int[] graph;
    static List<Node>[] list;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        list = new ArrayList[N + 1];
        graph = new int[N + 1];

        Arrays.fill(graph, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, 1));
        }


        Solve(X);

        for (int i = 1; i <= N; i++) {
            if (graph[i] == K) {
                answer.add(i);
            }
        }

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int n : answer) {
                System.out.println(n);
            }
        }
    }

    private static void Solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.offer(new Node(start, 0));
        graph[start] = 0; // 출발 정점 0으로 초기화

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(visited[n.v]) continue;

            visited[n.v] = true;

            for (Node next : list[n.v]) {
                if (graph[next.v] > graph[n.v] + next.w) {
                    graph[next.v] = graph[n.v] + next.w;
                    pq.offer(new Node(next.v, graph[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
