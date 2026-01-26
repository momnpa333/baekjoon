import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[][] score;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        board=new int[N][N];
        score=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(score[i][j]==0){
                    score[i][j]=dfs(i,j);
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                answer=Math.max(answer,score[i][j]);
            }
        }
        System.out.println(answer);

    }
    static int dfs(int r,int c){
        if(score[r][c]!=0){
            return score[r][c];
        }
        int ret=1;
        for(int k=0;k<4;k++){
            int nextR=r+dr[k];
            int nextC=c+dc[k];
            if(nextR>=0 && nextR<N && nextC>=0 && nextC<N && board[nextR][nextC]>board[r][c]){
                ret=Math.max(ret,dfs(nextR,nextC)+1);
            }
        }
        score[r][c]=ret;
        return ret;
    }


}

