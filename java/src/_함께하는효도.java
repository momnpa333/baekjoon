import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _함께하는효도 {
    static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int[][] pos;
    static int[][] board;
    static boolean[][] check;
    static int answer=0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        pos= new int[M][2];
        check= new boolean[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            pos[i][0]=r; pos[i][1]=c;
            check[r][c]=true;
        }
        dfs(0,pos[0][0],pos[0][1],0,board[pos[0][0]][pos[0][1]]);
        System.out.println(answer);
    }
    private static void dfs(int depth,int r,int c,int posCnt,int point){
        answer=Math.max(answer,point);
//        System.out.printf("r,c = %d %d depth,posCnt,point = %d %d %d\n",r,c,depth,posCnt,point+board[r][c]);
        if(depth>=3){
            if(posCnt<M-1){
                dfs(0,pos[posCnt+1][0],pos[posCnt+1][1],posCnt+1,point+board[pos[posCnt+1][0]][pos[posCnt+1][1]]);
            }
            return;
        }

        for(int i=0;i<dirs.length;i++){
            int newR=r+dirs[i][0]; int newC=c+dirs[i][1];

            if(newR>=0 && newR<N && newC>=0 && newC<N ){
                if(check[newR][newC]){
                    dfs(depth+1,newR,newC,posCnt,point);
                }
                else{
                    check[newR][newC]=true;
                    dfs(depth+1,newR,newC,posCnt,point+board[newR][newC]);
                    check[newR][newC]=false;
                }
            }
        }
    }

}
