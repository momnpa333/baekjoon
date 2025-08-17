import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2196 {
    static int N,M;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        dp=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=board[0][0];
        for(int i=1;i<M;i++){
            dp[0][i]=dp[0][i-1]+board[0][i];
        }

        for(int r=1;r<N;r++){
            int[] leftDp=new int[M];
            leftDp[0]=dp[r-1][0]+board[r][0];
            for(int c=1;c<M;c++){
                leftDp[c]=Math.max(leftDp[c-1],dp[r-1][c])+board[r][c];
            }
            int[] rightDp=new int[M];
            rightDp[M-1]=dp[r-1][M-1]+board[r][M-1];
            for(int c=M-2;c>=0;c--){
                rightDp[c]=Math.max(rightDp[c+1],dp[r-1][c])+board[r][c];
            }
            for(int c=0;c<M;c++){
                dp[r][c]=Math.max(leftDp[c],rightDp[c]);
            }
        }
//        for(int i=0;i<N;i++)
//            System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[N-1][M-1]);
    }

}
