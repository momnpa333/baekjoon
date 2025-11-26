import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] dp;
    static int MOD=987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        dp=new long[N+1];
        dp[0]=1;
        dp[2]=1;
        System.out.println(f(N));
//        System.out.println(Arrays.toString(dp));
    }
    static long f(int N){
        if(dp[N]!=0){
            return dp[N];
        }
        long ret=0;
        for(int i=N-2;i>=0;i-=2){
            ret+=(f(i)*f(N-i-2))%MOD;
            ret%=MOD;
        }
        dp[N]=ret;
        return ret;
    }
}