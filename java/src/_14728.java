import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14728 {
    static int N;
    static int T;
    static int[][] items;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        items=new int[N+1][2];
        dp=new int[N+1][T+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            items[i][0]=Integer.parseInt(st.nextToken());
            items[i][1]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=0;j<=T;j++){
                if(j<items[i][0]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-items[i][0]]+items[i][1]);
                }
            }
        }
        System.out.println(dp[N][T]);





    }

}
