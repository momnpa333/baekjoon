import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1103 {
    static int N,M;
    static int[][] board;
    static int[][][] dp;
    static int[] dr=new int[] {1,0,-1,0};
    static int[] dc=new int[] {0,1,0,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visited=new boolean[N][M];

        board=new int[N][M];
        dp=new int[N][M][5];


        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j)-'0';
            }
        }
        visited[0][0]=true;
        dfs(0,0);

        System.out.println(dp[0][0][4]);

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.println(Arrays.toString(dp[i][j]));
//            }
//        }


    }
    static int dfs(int r,int c){
        if(dp[r][c][4]!=0){
            return dp[r][c][4];
        }
        for(int i=0;i<4;i++){
            int R=r+dr[i]*board[r][c];
            int C=c+dc[i]*board[r][c];
            if(R>=0 && R<N && C>=0 && C<M && board[R][C]!=24){
                if(visited[R][C]){
                    dp[r][c][4]=-1;
                    return -1;
                }
                visited[R][C]=true;
                dp[r][c][i]=dfs(R,C)+1;
                if(dp[r][c][i]==0){
                    dp[r][c][4]=-1;
                    return -1;
                }
                visited[R][C]=false;
            }
            else{
                dp[r][c][i]=1;
            }
        }
        int ret=0;
        for(int i=0;i<4;i++){
            ret=Math.max(dp[r][c][i],ret);
        }
        dp[r][c][4]=ret;
        return ret;
    }



}
