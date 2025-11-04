import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        M=Integer.parseInt(st.nextToken());

        dp=new long[N+1];

        dp[0]=1; dp[1]=1;
        for(int i=2;i<=N;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        long ans=1;
        int start=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int end=Integer.parseInt(st.nextToken());
            ans*=dp[end-start-1];
            start=end;
//            System.out.println(ans);
        }
        ans*=dp[N-start];
        System.out.println(ans);
    }

}
