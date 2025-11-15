import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());
        seq=new int[N+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        dp=new int[2][N+1];

        Arrays.fill(dp[0],-987654321);
        Arrays.fill(dp[1],-987654321);

        dp[0][1]=seq[1];
        dp[1][1]=seq[1];

        for(int i=2;i<=N;i++){
            dp[0][i]=Math.max(seq[i],dp[0][i-1]+seq[i]);
            dp[1][i]=Math.max(seq[i],dp[1][i-1]+seq[i]);
            if(seq[i-1]<0){
                dp[1][i]=Math.max(dp[1][i-1]+seq[i],dp[0][i-2]+seq[i]);
            }
        }
//        System.out.println(Arrays.toString(dp[0]));
//        System.out.println(Arrays.toString(dp[1]));
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=N;i++){
            ans=Math.max(ans,dp[0][i]);
            ans=Math.max(ans,dp[1][i]);
        }
        System.out.println(ans);



    }
}