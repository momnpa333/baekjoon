import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[][] dp;
    static int[][] board;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        dp=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(findValue(0,0));
    }
    static int findValue(int r,int c){
        if(r>=N || c>=M) return 0;
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int ret=0;
        ret=Math.max(ret,findValue(r+1,c));
        ret=Math.max(ret,findValue(r,c+1));
        if(board[r][c]==1) ret+=1;
        dp[r][c]=ret;
        return dp[r][c];
    }
}
