import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, S;
    static int P, Q;
    static final long INF = 1_987_654_321_000L;

    static ArrayList<Integer>[] graph;
    static Set<Integer> zombies = new HashSet<>();
    static boolean[] danger;          // 위험지역 표시
    static long[] dist;               // 다익스트라 비용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int z = Integer.parseInt(br.readLine().trim());
            zombies.add(z);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 1) 멀티 소스 BFS로 위험 지역 표시
        markDangerZonesMultiSourceBFS();

        // 2) 다익스트라
        long answer = dijkstra();
        System.out.println(answer);
    }

    static void markDangerZonesMultiSourceBFS() {
        danger = new boolean[N + 1];
        int[] d = new int[N + 1];
        Arrays.fill(d, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 좀비들을 모두 거리 0으로 큐에 삽입 (멀티 소스)
        for (int z : zombies) {
            d[z] = 0;
            q.add(z);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (d[cur] == S) continue; // S까지만 확장

            for (int nxt : graph[cur]) {
                if (d[nxt] != -1) continue; // 이미 방문
                d[nxt] = d[cur] + 1;
                q.add(nxt);
            }
        }

        // 거리 1..S & 좀비가 아닌 정점은 위험 지역
        for (int v = 1; v <= N; v++) {
            if (d[v] != -1 && d[v] >= 1 && d[v] <= S && !zombies.contains(v)) {
                danger[v] = true;
            }
        }
    }

    static long dijkstra() {
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost != dist[cur.v]) continue;

            for (int nxt : graph[cur.v]) {
                if (zombies.contains(nxt)) continue; // 좀비 도시는 진입 불가

                long w = enterCost(nxt);
                if (dist[cur.v] + w < dist[nxt]) {
                    dist[nxt] = dist[cur.v] + w;
                    pq.add(new Node(nxt, dist[nxt]));
                }
            }
        }
        return dist[N];
    }

    static long enterCost(int node) {
        if (node == 1 || node == N) return 0; // 시작/도착 도시는 비용 0
        if (danger[node]) return Q;
        return P;
    }

    static class Node implements Comparable<Node> {
        int v;
        long cost;
        Node(int v, long cost) { this.v = v; this.cost = cost; }
        public int compareTo(Node o) { return Long.compare(this.cost, o.cost); }
    }
}
