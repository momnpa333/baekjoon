import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9466 {
    static int[] graph;
    static boolean[] visited, finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i);
            }

            // 총 인원 N에서 사이클에 포함된 사람 수 count를 뺌
            System.out.println(N - count);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = graph[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발견
            for (int i = next; i != now; i = graph[i]) {
                count++;
            }
            count++; // 자기 자신도 포함
        }

        finished[now] = true;
    }

}
