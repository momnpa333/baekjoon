import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] corns;
    static int score;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        corns=new int[N+2];
        dp=new int[N+2][N+2];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            corns[i]=Integer.parseInt(st.nextToken());
        }
        for(int l=0;l<N;l++){
            dfs(l,l+1,N);
            score= Math.max(dp[l][l+1],score);
        }
        System.out.println(score);
    }
    static int dfs(int left,int right,int round){
        if(round<=0 || left<0 || right>N+1){
            return 0;
        }
        if(dp[left][right]!=0){
            return dp[left][right];
        }
        int ret=0;
        ret=Math.max(dfs(left-1,right,round-1)+round*corns[left],dfs(left,right+1,round-1)+round*corns[right]);
        dp[left][right]=ret;
//        System.out.println(left+" "+right+" "+dp[left][right]);
        return dp[left][right];
    }
}




