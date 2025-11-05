import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int[][] horizon;
    static int[][] vertical;
    static int[][] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        horizon=new int[N+1][M+1];
        vertical=new int[N+1][M+1];
        dp=new int[N+1][M+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(board[i-1][j-1]==0){
                    horizon[i][j]=horizon[i][j-1]+1;
                }
            }
//            System.out.println(Arrays.toString(horizon[i]));
        }

        for(int c=1;c<=M;c++){
            for(int r=1;r<=N;r++){
                if(board[r-1][c-1]==0){
                    vertical[r][c]=vertical[r-1][c]+1;
                }
            }
        }

        for(int r=1;r<=N;r++){
            for(int c=1;c<=M;c++){
                int size=Math.min(vertical[r][c],horizon[r][c]);
                dp[r][c]=Math.min(size,dp[r-1][c-1]+1);
                ans=Math.max(ans,dp[r][c]);
            }
        }
        System.out.println(ans);

//        for(int i=1;i<=N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

}
