import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9764 {
    static int T;
    static int N;
    static int[][] dp;
    static int MOD=100999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        dp=new int[2001][2001];

        for(int i=1;i<=2000;i++){
            dp[i][i]=1;
            dp[i][0]=1;
        }
        for(int i=2;i<=2000;i++){
            for(int j=i-1;j>0;j--){
                for(int k=j-1;k>0;k--){
                    if(dp[i-j][k]==0) break;
                    dp[i][j]=(dp[i][j]+dp[i-j][k])%MOD;
                }
                dp[i][0]=(dp[i][0]+dp[i][j])%MOD;

            }
//            System.out.println(dp[i][0]);
        }


        while(T-->0){
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N][0]);
        }

    }
}
