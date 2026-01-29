import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] apps;
    static int[] costs;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        apps=new int[N+1];
        costs=new int[N+1];
        dp=new int[N+1][10001];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            apps[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            costs[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=0;j<=10000;j++){
                if(j-costs[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-costs[i]]+apps[i]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

//        for(int i=1;i<=N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        for(int i=0;i<=10000;i++){
            for(int r=1;r<=N;r++){
                if(dp[r][i]>=M){
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}

