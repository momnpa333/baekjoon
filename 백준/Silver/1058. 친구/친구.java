import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        board=new char[N][N];
        dp=new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],987654321);
//            System.out.println(Arrays.toString(dp[i]));
        }

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                board[i][j]=s.charAt(j);
                if(board[i][j]=='Y'){
                    dp[i][j]=1;
                }
            }
        }
        for(int via=0;via<N;via++){
            for(int s=0;s<N;s++){
                for(int e=0;e<N;e++){
                    if(dp[s][via]+dp[via][e]<dp[s][e]){
                        dp[s][e]=dp[s][via]+dp[via][e];
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<N;i++){
            int cnt=0;
            for(int j=0;j<N;j++){
                if(i!=j && dp[i][j]<=2){
                    cnt++;
                }
            }
            ans=Math.max(ans,cnt);
        }
        System.out.println(ans);
    }


}
