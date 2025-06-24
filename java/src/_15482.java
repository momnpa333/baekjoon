import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15482 {
    static String A;
    static String B;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A=br.readLine();

        B=br.readLine();

        dp=new int[A.length()+1][B.length()+1];

//        System.out.printf("%s %s\n",A,B);

        for(int i=1;i<A.length()+1;i++){
            for(int j=1;j<B.length()+1;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,Math.max(dp[i-1][j],dp[i][j-1]));
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        for(int[]v:dp){
//            System.out.println(Arrays.toString(v));
//        }
        System.out.println(dp[A.length()][B.length()]);


    }

}
