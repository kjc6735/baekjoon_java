package DisjoinSetTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimPQTest {

    static class Vertex implements Comparable<Vertex> {
        int no, weight;// 정점번호 , 트리정점과 연결했을 때의 간선비용

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {

            return Integer.compare(this.weight, o.weight);
        }

    }

    static int V, adjMatrix[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adjMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[V];
        int[] minEdge = new int[V];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 갱신

        minEdge[0] = 0; // 임의의 0정점을 트리 구성의 시작으로 하기 위해 세팅

        pq.offer(new Vertex(0, minEdge[0]));

        int result = 0; // 최소 신장트리의 비용
        int min = 0;
        int minVertex = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            // step1 : 미방문(비트리) 정점 중 최소간선비용의 정점을 선택

            Vertex cur = pq.poll();
            minVertex = cur.no;
            min = cur.weight;

            if (visited[minVertex])
                continue;

            // step2 : 방문(트리) 정점에 추가
            visited[minVertex] = true; // 방문 처리
            result += min; // 신장트리 비용 누적

            if (++cnt == V)
                break;
            // step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고요 (영업타임)
            for (int i = 0; i < V; i++) {
                if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                    pq.offer(new Vertex(i, minEdge[i]));
                }
            }
        }

    }
}
