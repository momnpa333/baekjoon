import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        dp=new int[N+1][3];
        dp[1][0]=1; dp[1][1]=1; dp[1][2]=1;

        for(int i=2;i<=N;i++){
            dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
//            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%9901);
    }


}
