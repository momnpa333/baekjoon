import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] dp;
    static int[] board;
    static int ans1;
    static int ans2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());

        dp=new boolean[2][N+1];
        board=new int[N+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            board[i]=Integer.parseInt(st.nextToken());
        }

        dp[0][0]=true;
        dp[1][0]=false;

        for(int i=1;i<=N;i++){
            if(board[i]!=0){
                ans1+=board[i];
                ans2+=board[i];
                continue;
            }
            if(!dp[0][i-1]){
                if(i==N && dp[0][1]) continue;
                dp[0][i]=true;
                ans1+=1;
            }
            if(!dp[1][i-1]){
                if(i==N && dp[1][1]) continue;
                dp[1][i]=true;
                ans2+=1;
            }
        }
        System.out.println(Math.max(ans1,ans2));

    }
}