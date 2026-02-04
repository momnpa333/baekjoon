import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static long[][] dp;
    static long MOD=1_000_000_003;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        K=Integer.parseInt(st.nextToken());

        dp=new long[N+1][K+1];
        System.out.println(color(N,K));
//        for(int i=0;i<=N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }


    }
    static long color(int n,int k){
//        System.out.println(n+" "+k);
        if(n<=0 || n<k*2) return 0;
        if(k*2==n) return 2;
        if(dp[n][k]!=0) return dp[n][k];
        if(k==1){
            dp[n][k]=n;
            return dp[n][k];
        }
        dp[n][k]=(color(n-1,k)+color(n-2,k-1))%MOD;
        return dp[n][k];
    }

}

