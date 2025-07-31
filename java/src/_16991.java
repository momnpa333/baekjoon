import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16991 {
    static int N;
    static int[][] cities;
    static double[][] length;
    static double[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        dp=new double[N+1][2<<(N-2)];
        for(int i=0;i<=N;i++)
            Arrays.fill(dp[i],Double.MAX_VALUE);
        cities=new int[N+1][2];
        length=new double[N+1][N+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            cities[i][0]=Integer.parseInt(st.nextToken());  cities[i][1]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                length[i][j]= Math.sqrt(Math.pow(cities[i][0]-cities[j][0],2)+Math.pow(cities[i][1]-cities[j][1],2));
            }
        }

        for(int start=2;start<=N;start++){
            dp[start][0]=length[start][1];
        }
        for(int i=1;i<(1<<(N-1))-1;i++){
            for(int j=2;j<=N;j++){
                if((i&(2<<j-2))>>(j-1)==0){
                    dfs(i,j);
                }
            }
        }
        System.out.println(dfs((1<<(N-1))-1,1));
    }

    static double dfs(int via,int start){
        double ret=Double.MAX_VALUE;

        if(dp[start][via]!=Double.MAX_VALUE){
            return dp[start][via];
        }
        for(int i=2;i<=N;i++){
            if((via&(1<<(i-2)))>>(i-2)==1){
                ret=Math.min(length[start][i]+dfs(via-(1<<(i-2)),i),ret);
            }
        }
        dp[start][via]=ret;
        return ret;
    }
}
