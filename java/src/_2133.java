import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2133 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        dp=new int[Math.max(N+1,3)];
        dp[0]=1;    dp[2]=3;

        for(int i=4;i<=N;i++){
            if(i%2==0){
                dp[i]=dp[i-2]*3;
                for(int j=i-4;j>=0;j-=2){
                    dp[i]+=dp[j]*2;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
