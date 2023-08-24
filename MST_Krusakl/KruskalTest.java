package MST_Krusakl;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class KruskalTest {

    //1.엣지 리스트 생성
    //2. 엣지 넣어주기
    //3. 정렬
    //4. V개의 정점으로 make set 작업

    static Edge[] edges;
    static int V, E;
    static int[] parents;


    //이것만 이해하면 됨
    static int find(int a) {
        if (parents[a] == a) { // 만약 부모가 나라면
            return a;
        }
        return parents[a] = find(parents[a]); // 아니면 부모로 업뎃해주기 
    }

    static void make(int V) {
        parents = new int[V + 1]; //정점 번호가 1부터 시작하므로 +1
        for (int i = 0; i < V + 1; i++) {
            parents[i] = i;
        }
        
    }

    static boolean union(int a ,int b){
        int aRoot = find(a); // 에이 부모 
        int bRoot = find(b); // 비 부모
        if (aRoot == bRoot) // 같은건 같은 부모임
            return false;
        parents[bRoot] = aRoot; // 싸이클이 발생했다는 의미
        return true;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("MST_Krusakl/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수

        edges = new Edge[E]; // 간선 갯수 생성

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()); 
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);  // 간선과 가중치 넣어주기 
        }
        
        Arrays.sort(edges); //comparable에 따른 정렬 (간선이 작은 순으로 정렬함 )

        make(V); // 노드 만들어주기

        int result = 0; // MST비용
        int count = 0; // 간선의 갯수
        for(Edge e : edges){ // 순회
            if (union(e.from, e.to)) { // 싸이클이 발생했는지 확인
                result += e.weight; // 가중치 누적
                if(++count == V) break; // 총 간선의 갯수가 V개 (정점갯수 -1개가 멈출 조건임)
            }
        }
        System.out.println(result);
    }    


    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        //weight를 기준으로 정렬하기 위해 오름차순 정렬 (작은 간선부터 봐야하기 때문에)
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
            
        }   
    }
}
