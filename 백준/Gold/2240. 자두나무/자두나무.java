import java.io.*;
import java.util.*;

public class Main {
    static int T,W;
    static int[] peach;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        T=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        dp=new int[W+1][T+1][3];
        peach=new int[T+1];
        for(int i=0;i<=W;i++){
            for(int j=0;j<=T;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int i=1;i<=T;i++){
            st=new StringTokenizer(br.readLine()," ");
            peach[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0,1,0);

//        for(int i=0;i<=W;i++){
//            for(int j=0;j<=T;j++){
//                System.out.println(Arrays.toString(dp[i][j]));
//            }
//        }
        int ans=0;
        for(int i=0;i<=W;i++){
            ans=Math.max(dp[i][T][1],ans);
            ans=Math.max(dp[i][T][2],ans);
        }
        System.out.println(ans);


    }
    static void dfs(int w,int t,int pos,int prev){
        if(w>W || t>T) return;
//        System.out.println(w+" "+t+" "+pos);
        int cur=0;
        if(peach[t]==pos){
            cur+=1;
        }
        if(prev+cur>dp[w][t][pos]) {
            dp[w][t][pos]=prev+cur;
        }
        else{
            return;
        }
        dfs(w+1,t+1,pos==2?1:2,dp[w][t][pos]);
        dfs(w,t+1,pos,dp[w][t][pos]);
    }
}