import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1958 {
    static String s1,s2,s3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1=" "+br.readLine();   s2=" "+br.readLine();  s3=" "+br.readLine();
        System.out.println(lcsV3(s1,s2,s3));

    }
    static int lcsV3(String st1,String st2,String st3){
        int N=st1.length();   int M=st2.length();   int K=st3.length();
        int[][][] dp=new int[N][M][K];

        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                for(int k=1;k<K;k++){
                    if(st1.charAt(i)==st2.charAt(j) && st1.charAt(i)==st3.charAt(k)){
                        dp[i][j][k]=dp[i-1][j-1][k-1]+1;
                    }
                    else{
                        int candi=0;
                        candi=Math.max(dp[i-1][j][k],candi);
                        candi=Math.max(dp[i][j-1][k],candi);
                        candi=Math.max(dp[i][j][k-1],candi);
                        dp[i][j][k]=candi;
                    }
                }
            }
        }
        return dp[N-1][M-1][K-1];
    }

}
