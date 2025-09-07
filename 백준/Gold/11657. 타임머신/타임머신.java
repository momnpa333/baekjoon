import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int u, v;
        long w;
        Edge(int u, int v, long w) { this.u = u; this.v = v; this.w = w; }
    }

    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken()); // 음수 가능
            edges.add(new Edge(s, e, t));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // N-1번 완화
        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Edge ed : edges) {
                if (dist[ed.u] == INF) continue;
                long nd = dist[ed.u] + ed.w;
                if (nd < dist[ed.v]) {
                    dist[ed.v] = nd;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        // N번째 완화가 가능하면 음수 사이클(1에서 도달 가능)
        for (Edge ed : edges) {
            if (dist[ed.u] == INF) continue;
            if (dist[ed.u] + ed.w < dist[ed.v]) {
                System.out.println(-1);
                return;
            }
        }

        // 결과 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(dist[i] == INF ? -1 : dist[i]);
        }
    }
}
