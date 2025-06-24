import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1890 {
    static int N,answer;
    static long[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        dp=new long[N][N];
        board=new int[N][N];

        for(int r=0;r<N;r++){
            st=new StringTokenizer(br.readLine()," ");

            for(int c=0;c<N;c++){
                board[r][c]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=1;
        dfs(N-1,N-1);

//        for(int[] v:dp){
//            System.out.println(Arrays.toString(v));
//        }
        System.out.println(dp[N-1][N-1]);

    }

    static long dfs(int r,int c){
        int rLen=0; int cLen=0;
//        System.out.printf("%d %d\n",r,c);
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        for(int i=r-1;i>-1;i--){
            rLen++;
            if(board[i][c]==rLen){
                dp[r][c]+=dfs(i,c);
            }
        }

        for(int j=c-1;j>-1;j--){
            cLen++;
            if(board[r][j]==cLen){
                dp[r][c]+=dfs(r,j);
            }
        }
        return dp[r][c];
    }

}
