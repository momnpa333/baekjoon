import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1799 {
    static int N;
    static int[][] board;
    static int[][] bishop;
    static int[] dr={1,1,-1,-1};
    static int[] dc={1,-1,1,-1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        board=new int[N][N];
        bishop=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);
        dfs(0,1,answer);

        System.out.println(answer);

    }
    static void dfs(int r,int c,int cnt){
        answer=Math.max(answer,cnt);

        for(int i=c;i<N;i+=2){
            if(board[r][i]==1 && bishop[r][i]==0){
                putBishop(r,i);
                dfs(r,i,cnt+1);
                backUp(r,i);
            }
        }
        for(int i=r+1;i<N;i++){
            for(int j=(c+1)%2;j<N;j+=2){
                if(board[i][j]==1 && bishop[i][j]==0){
                    putBishop(i,j);
                    dfs(i,j,cnt+1);
                    backUp(i,j);
                }
            }
            c++;
        }
    }
    static void putBishop(int r,int c){
        bishop[r][c]+=1;
        for(int i=1;i<=N;i++){
            for(int j=0;j<4;j++){
                int curR=r+dr[j]*i;
                int curC=c+dc[j]*i;
                if(curR>=0 && curR<N && curC>=0 && curC<N){
                    bishop[curR][curC]+=1;
                }
            }
        }
    }
    static void backUp(int r,int c){
        bishop[r][c]-=1;
        for(int i=1;i<=N;i++){
            for(int j=0;j<4;j++){
                int curR=r+dr[j]*i;
                int curC=c+dc[j]*i;
                if(curR>=0 && curR<N && curC>=0 && curC<N){
                    bishop[curR][curC]-=1;
                }
            }
        }
    }

}
