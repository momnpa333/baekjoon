import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N,M;
    static int[] scores;
    static boolean[][] dp;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            scores=new int[M];
            dp=new boolean[N+1][501];
//            for(int i=0;i<=N;i++)
//                Arrays.fill(dp[i],-1);
            st=new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                scores[i]=Integer.parseInt(st.nextToken());
            }
            int ans=-1;
            dfs(0,0,0);
            for(int i=0;i<501;i++){
                if(dp[N][i]){
                    ans=i;
                }
            }
            System.out.println(ans);
//            System.out.println(Arrays.toString(dp[N]));
        }
    }
    static void dfs(int pushUp,int score,int total){
//        System.out.println(pushUp+" "+score+" "+total);
        if(pushUp>N) return;
        if(dp[pushUp][total]) return;
        dp[pushUp][total]=true;
        if(pushUp==N) return;
        for(int i=0;i<M;i++){
            dfs(pushUp+total+scores[i],scores[i],total+scores[i]);
        }
    }
}