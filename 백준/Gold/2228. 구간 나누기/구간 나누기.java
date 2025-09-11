import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] seq;
    static int[][][] dp;
    static boolean[][][] vis;              // ★ 계산 여부 플래그 추가
    static int NEG_INF = -1_000_000_000;

    static int[][] maxRange;   // maxRange[L][R] = [L..R] 내부 최대 부분합
    static boolean[] built;    // 각 L(=start)의 행을 채웠는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];
        dp  = new int[M+1][N][N];
        vis = new boolean[M+1][N][N];      // ★ 추가

        for (int i=0;i<=M;i++){
            for (int j=0;j<N;j++){
                Arrays.fill(dp[i][j], NEG_INF);
            }
        }

        maxRange = new int[N][N];
        built    = new boolean[N];
        for (int i = 0; i < N; i++) Arrays.fill(maxRange[i], NEG_INF);

        for (int i=0;i<N;i++){
            seq[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(dfs(M, 0, N-1));
    }

    static int dfs(int divide, int start, int end){
        // ★ 경계 및 불가능 상태 컷
        if (start > end) return NEG_INF;
        int len = end - start + 1;
        int need = 2*divide - 1;           // 각 구간 1칸 + 사이 공백 1칸씩
        if (len < need) return NEG_INF;

        // ★ 이미 계산된 경우
        if (vis[divide][start][end]) return dp[divide][start][end];
        vis[divide][start][end] = true;

        if (divide == 1){
            return dp[divide][start][end] = findMax(start, end);
        }

        int best = NEG_INF;

        // ★ 분할 인덱스 상한 축소
        // 오른쪽에 (divide-1)개 구간을 배치할 최소 길이: 2*(divide-1)-1 = 2*divide - 3
        // rightLen = end - (i+2) + 1 = end - i - 1 >= 2*divide - 3
        // => i <= end - (2*divide - 3) - 1 = end - 2*divide + 2
        int iMax = Math.min(end - 2, end - 2*divide + 2);
        for (int i = start; i <= iMax; i++){
            int left  = findMax(start, i);           // O(1)
            int right = dfs(divide - 1, i + 2, end);
            if (right != NEG_INF){
                best = Math.max(best, left + right);
            }
        }
        return dp[divide][start][end] = best;
    }

    static int findMax(int start, int end){
        // start 행을 한 번만 Kadane 누적으로 채움 → 이후 O(1) 조회
        if (!built[start]) {
            int cur  = seq[start];
            int best = seq[start];
            maxRange[start][start] = best;
            for (int r = start + 1; r < N; r++) {
                cur  = Math.max(seq[r], cur + seq[r]);
                best = Math.max(best, cur);
                maxRange[start][r] = best;
            }
            built[start] = true;
        }
        return maxRange[start][end];
    }
}
