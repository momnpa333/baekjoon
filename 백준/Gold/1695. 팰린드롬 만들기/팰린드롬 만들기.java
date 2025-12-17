import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static int[] reverseSeq;
    static int[][] dp;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        seq=new int[N+1];
        reverseSeq=new int[N+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
            reverseSeq[N-i+1]=seq[i];
        }
        dp=new int[N+1][N+1];
//        System.out.println(Arrays.toString(seq));
//        System.out.println(Arrays.toString(reverseSeq));
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
//                System.out.println(seq[i]+" "+reverseSeq[j]);
                if(seq[i]==reverseSeq[j]){
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i-1][j-1]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]);
                    dp[i][j]=Math.max(dp[i][j-1],dp[i][j]);
                }
            }
        }
//        for(int i=0;i<=N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        for(int j=1;j<=N;j++){
            ans=Math.max(dp[N][j],ans);
        }

        System.out.println(N-ans);
    }
}


