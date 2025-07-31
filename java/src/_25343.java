import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _25343 {
    static int N;
    static int[][] board;
    static int[][] dp;
    static int[] dr={0,1};
    static int[] dc={1,0};
    static int answer=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        board=new int[N][N];    dp=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{0,0});

        boolean[][] visited=new boolean[N][N];
        dp[0][0]=1;

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.poll();
                for(int j=0;j<2;j++){
                    int curR=item[0]+dr[j]; int curC=item[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<N && !visited[curR][curC]){
                        visited[curR][curC]=true;
                        int tar=findMax(curR,curC);
                        dp[curR][curC]=tar+1;
                        answer=Math.max(tar+1,answer);
                        dq.add(new int[]{curR,curC});
                    }
                }
            }
        }

//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(answer);

    }
    static int findMax(int r,int c){
        int origin=board[r][c];
        int curMax=0;
        boolean[][] visited=new boolean[N][N];
        ArrayDeque<int[]>dq=new ArrayDeque<>();
        dq.add(new int[]{r,c});
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.poll();
                for(int j=0;j<2;j++){
                    int curR=item[0]-dr[j]; int curC=item[1]-dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<N  &&!visited[curR][curC]){
                        visited[curR][curC]=true;
                        if(board[curR][curC]<origin){
                            curMax=Math.max(dp[curR][curC],curMax);
                        }
                        dq.add(new int[]{curR,curC});
                    }
                }
            }
        }
        return curMax;

    }

}
