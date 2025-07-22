import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5582 {
    static String A;
    static String B;
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        A=br.readLine(); B=br.readLine();

        dp=new int[A.length()+1][B.length()+1];

        for(int i=1;i<A.length()+1;i++){
            for(int j=1;j<B.length()+1;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    answer=Math.max(answer,dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
