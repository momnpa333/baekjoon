import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] fillBoard;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        fillBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                int h = s.charAt(j) - '0';
                board[i][j] = h;
                fillBoard[i][j] = h;
            }
        }

        // 높이 1~9(또는 1~8) 레벨별로 외부 누수 영역을 표시 후 내부만 채움
        for (int h = 1; h <= 9; h++) {
            bfsFillLevel(h);
        }

        // 채워진 총량 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += (fillBoard[i][j] - board[i][j]);
            }
        }
        System.out.println(ans);
    }

    // 레벨 h에서 바깥으로 새는 칸(높이 < h)을 경계에서 BFS로 전부 표시하고,
    // 표시되지 않은 높이 < h 칸을 h로 끌어올림
    static void bfsFillLevel(int h) {
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 경계에서 시작: 높이 < h 인 칸을 큐에 넣음 (밖과 통하는 물 영역)
        for (int r = 0; r < N; r++) {
            if (fillBoard[r][0] < h) { q.add(new int[]{r, 0}); visited[r][0] = true; }
            if (fillBoard[r][M - 1] < h) { q.add(new int[]{r, M - 1}); visited[r][M - 1] = true; }
        }
        for (int c = 0; c < M; c++) {
            if (fillBoard[0][c] < h) { q.add(new int[]{0, c}); visited[0][c] = true; }
            if (fillBoard[N - 1][c] < h) { q.add(new int[]{N - 1, c}); visited[N - 1][c] = true; }
        }

        // 바깥으로 새는 낮은 칸들(높이 < h) 전체를 확장
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (fillBoard[nr][nc] < h) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // 방문되지 않은(=둘러싸인) 높이 < h 칸을 h로 채움
        for (int r = 1; r < N - 1; r++) {
            for (int c = 1; c < M - 1; c++) {
                if (fillBoard[r][c] < h && !visited[r][c]) {
                    fillBoard[r][c] = h;
                }
            }
        }
    }
}
