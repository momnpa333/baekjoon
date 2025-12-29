import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans;
    static boolean[][] visited = new boolean[50][50]; // 충분히 크게 (중심 오프셋 사용)
    static int[] dr = {-1, -1, 0, 1, 1, 0};
    static int[] dc = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        visited[25][25]=true;
        go(25,25,0,0);

        System.out.println(ans);
    }
    static void dfs(int r, int c, int dir, int depth) {
        int left = (dir + 5) % 6;
        int right = (dir + 1) % 6;

        go(r, c, left, depth + 1);
        go(r, c, right, depth + 1);
    }

    static void go(int r,int c,int dir,int depth){
//        System.out.println(r+" "+c);
        if(depth>N) return;
        int nextR=r+dr[dir];
        int nextC=c+dc[dir];
        if(visited[nextR][nextC]){
            if(depth==N){
                ans++;
            }
            return;
        }
        if(depth>=N) return;
        visited[nextR][nextC] = true;
        dfs(nextR, nextC, dir, depth);
        visited[nextR][nextC] = false;
    }
}