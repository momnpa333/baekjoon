import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1562 {
    static int N;
    static int[][][] dp;
    static long answer;
    static int MOD=1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());

        dp=new int[N+1][10][1024];

        for(int i=0;i<=9;i++){
            dp[1][i][1<<i]+=1;
//            System.out.println(Arrays.toString(dp[1][i]));
        }

        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                if(j==0){
                    for(int k=0;k<1024;k++){
                        dp[i][j][k|(1<<j)]=(dp[i][j][k|(1<<j)]+dp[i-1][1][k])%MOD;
                    }
                }
                else if(j>=1 && j<=8){
                    for(int k=0;k<1024;k++){
                        dp[i][j][k|(1<<j)]=(dp[i][j][k|(1<<j)]+dp[i-1][j-1][k])%MOD;
                        dp[i][j][k|(1<<j)]=(dp[i][j][k|(1<<j)]+dp[i-1][j+1][k])%MOD;
                    }
                }
                else{
                    for(int k=0;k<1024;k++){
                        dp[i][j][k|(1<<j)]=(dp[i][j][k|(1<<j)]+dp[i-1][8][k])%MOD;
                    }
                }
            }
        }

        for(int i=1;i<=9;i++){
            answer=(answer+dp[N][i][1023])%MOD;
        }
        System.out.println(answer);


    }


}
