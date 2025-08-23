import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int[] coins;
    static int tar;
    static long[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            N=Integer.parseInt(br.readLine());
            coins=new int[N+1];
            st=new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=N;i++){
                coins[i]=Integer.parseInt(st.nextToken());
            }
            tar=Integer.parseInt(br.readLine());
            dp=new long[N+1][tar+1];

            for(int i=1;i<=N;i++){
                for(int j=0;j<=tar;j++){
                    if(j==0){
                        dp[i][j]=1;
                        continue;
                    }
                    if(j<coins[i]){
                        dp[i][j]=dp[i-1][j];
                    }
                    else{
                        dp[i][j]+=dp[i-1][j];
                        dp[i][j]+=dp[i][j-coins[i]];
                    }
                }
            }
//            for(int i=0;i<=N;i++){
//                System.out.println(Arrays.toString(dp[i]));
//            }

            System.out.println(dp[N][tar]);
        }

    }
}
