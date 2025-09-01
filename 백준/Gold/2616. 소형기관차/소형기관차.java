import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int[] trains;
    static int[] fixSum;
    static int cap;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        trains=new int[N];
        fixSum=new int[N+1];
        dp=new int[3][N];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            trains[i]=Integer.parseInt(st.nextToken());
        }
        cap=Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++){
            fixSum[i]=fixSum[i-1]+trains[i-1];
        }

        for(int j=0;j<N;j++){
            if(j>=cap-1){
                dp[0][j]=Math.max(dp[0][j-1],fixSum[j+1]-fixSum[j+1-cap]);
            }
        }
//        System.out.println(Arrays.toString(dp[0]));

        for(int i=1;i<3;i++){
            for(int j=1;j<N;j++){
                if(j<cap){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-cap]+fixSum[j+1]-fixSum[j+1-cap]);
                }
            }
        }
//        for(int i=0;i<3;i++)
//            System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[2][N-1]);


    }


}
