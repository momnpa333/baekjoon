import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int[] startA;
    static int[] startB;
    static boolean[][] complete;
    static int cntA;
    static int cntB;
    static int cntC;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        startA=new int[2];
        startB=new int[2];
        board=new int[N][M];
        complete=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    startA[0]=i;
                    startA[1]=j;
                    complete[i][j]=true;
                }
                if(board[i][j]==2){
                    startB[0]=i;
                    startB[1]=j;
                    complete[i][j]=true;
                }
            }
        }

        ArrayDeque<int[]> dqA = new ArrayDeque<>();
        ArrayDeque<int[]> dqB = new ArrayDeque<>();
        dqA.add(new int[]{startA[0],startA[1]});
        dqB.add(new int[]{startB[0],startB[1]});

        while(!dqA.isEmpty() || !dqB.isEmpty()){
            int L=dqA.size();
            for(int i=0;i<L;i++){
                int[] item=dqA.poll();
                if(board[item[0]][item[1]]==3){
                    continue;
                }
                complete[item[0]][item[1]]=true;
                for(int j=0;j<4;j++){
                    int curR=item[0]+dr[j];
                    int curC=item[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && !complete[curR][curC]){
                        if(board[curR][curC]==0){
                            board[curR][curC]=1;
                            dqA.add(new int[]{curR,curC});
                        }
                        else if(board[curR][curC]==2){
                            board[curR][curC]=3;
                            complete[curR][curC]=true;
                        }
                    }
                }
            }
            L=dqB.size();
            for(int i=0;i<L;i++){
                int[] item=dqB.poll();
                if(board[item[0]][item[1]]==3){
                    continue;
                }
                complete[item[0]][item[1]]=true;
                for(int j=0;j<4;j++){
                    int curR=item[0]+dr[j];
                    int curC=item[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && !complete[curR][curC]){
                        if(board[curR][curC]==0){
                            board[curR][curC]=2;
                            dqB.add(new int[]{curR,curC});
                        }
                        else if(board[curR][curC]==1){
                            board[curR][curC]=3;
                            complete[curR][curC]=true;
                        }
                    }
                }
            }
            for(int[] item:dqA){
                complete[item[0]][item[1]]=true;
            }
            for(int[] item:dqB){
                complete[item[0]][item[1]]=true;
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==1){
                    cntA++;
                }
                if(board[i][j]==2){
                    cntB++;
                }
                if(board[i][j]==3){
                    cntC++;
                }
            }
        }
        System.out.printf("%d %d %d",cntA,cntB,cntC);

    }
}
