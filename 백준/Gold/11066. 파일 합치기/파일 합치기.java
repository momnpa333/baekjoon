import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int[] costs;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine(), " ");
            N=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            costs=new int[N];
            sum=new int[N+1];
            dp=new int[N][N];
            for(int i=0;i<N;i++){
                costs[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                sum[i+1]=costs[i]+sum[i];
            }
            System.out.println(getCost(0,N-1));
        }

    }
    static int getCost(int start,int end){
        if(start==end){
            return 0;
        }
        if(start+1==end){
            dp[start][end]=costs[start]+costs[end];
            return dp[start][end];
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        int ret=Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            int tmp1=getCost(start,i);
            int tmp2=getCost(i+1,end);
            ret=Math.min(tmp1+tmp2+sum[end+1]-sum[start],ret);
        }
        dp[start][end]=ret;
        return ret;

    }


}
