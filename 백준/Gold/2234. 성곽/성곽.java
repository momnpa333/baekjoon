import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int[][] wall;
    static int[] dr={0,-1,0,1};
    static int[] dc={-1,0,1,0};
    static int ans2;
    static int[] roomCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        wall=new int[N][M];
        roomCnt=new int[N*M+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                wall[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cnt=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
//                System.out.println(i);
                if(board[i][j]==0){
                    roomCnt[cnt]=bfs(i,j,cnt);
                    ans2=Math.max(ans2,roomCnt[cnt]);
                    cnt++;
                }
            }
        }
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
        System.out.println(cnt-1);
        System.out.println(ans2);
        System.out.println(merge());
    }
    static int merge(){
        int ret=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<4;k++){
                    int curR=i+dr[k];
                    int curC=j+dc[k];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && board[curR][curC]!=board[i][j]){
                        ret=Math.max(ret,roomCnt[board[curR][curC]]+roomCnt[board[i][j]]);
                    }
                }
            }
        }
        return ret;
    }
    static int bfs(int r,int c,int num){
        ArrayDeque<int[]>dq=new ArrayDeque<>();
        dq.add(new int[]{r,c,num});
        board[r][c]=num;
        int ret=1;

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.poll();
                for(int j=0;j<4;j++){
                    if((wall[item[0]][item[1]]>>j)%2==0){
                        int curR=item[0]+dr[j];
                        int curC=item[1]+dc[j];
                        if(board[curR][curC]==0){
                            board[curR][curC]=num;
                            ret++;
                            dq.add(new int[]{curR,curC,num});
                        }
                    }
                }
            }
        }
        return ret;
    }
}
