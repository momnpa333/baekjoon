import java.io.*;
import java.util.*;

public class _17845 {
    static int N,K;
    static int[][] items;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());
        items=new int[K+1][2];
        dp=new int[K+1][N+1];
        for(int i=1;i<=K;i++){
            st=new StringTokenizer(br.readLine()," ");
            items[i][0]=Integer.parseInt(st.nextToken());
            items[i][1]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=K;i++){
            for(int j=0;j<=N;j++){
                if(j>=items[i][1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-items[i][1]]+items[i][0]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[K][N]);
    }

}
