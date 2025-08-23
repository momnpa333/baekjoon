import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());

        StringBuilder out = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            bridge = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) bridge[i] = Integer.parseInt(st.nextToken());

            out.append(countInversions()).append('\n'); // ★ 전체 입력 후 한 번만 호출
        }
        System.out.print(out);
    }

    // 버블 스왑 횟수 = 인접 교환 횟수 = 가로줄 최소 개수
    static int countInversions() {
        int cnt = 0;
        // 1-indexed 배열이므로 1..N-1, j는 1..N-i
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (bridge[j] > bridge[j + 1]) {
                    int tmp = bridge[j];
                    bridge[j] = bridge[j + 1];
                    bridge[j + 1] = tmp;
                    cnt++; // 인접 교환 1회 = 가로줄 1개
                }
            }
        }
        return cnt;
    }
}
