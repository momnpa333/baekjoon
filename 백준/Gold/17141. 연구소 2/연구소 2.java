import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static ArrayList<int[]> bombs;
    static int INF=987654321;
    static int answer=INF;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        bombs=new ArrayList<>();
        board=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(board[i]));
        }
        combi(0,0);
        if(answer==INF){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
    static boolean isDone(boolean[][] visited){
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(visited[i]));
//        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]!=1 && !visited[i][j]){
//                    System.out.printf("%d %d\n",i,j);
                    return false;
                }
            }
        }
//        System.out.println("!!");
        return true;
    }
    static int bfs(){
        int time=0;
        boolean[][] visited=new boolean[N][N];
        ArrayDeque<Item> dq=new ArrayDeque<>();
        for(int[] bomb:bombs){
            dq.add(new Item(bomb[0],bomb[1]));
            visited[bomb[0]][bomb[1]]=true;
        }
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int j=0;j<4;j++){
                    int curR=item.r+dr[j];
                    int curC=item.c+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<N && !visited[curR][curC] && board[curR][curC]!=1){
                        visited[curR][curC]=true;
                        dq.add(new Item(curR,curC));
                    }
                }
            }
            time++;
        }
        if(isDone(visited)) return time-1;
        return INF;

    }
    static void combi(int start,int bombCnt){
        if(bombCnt==M){
            answer=Math.min(answer,bfs());
            return;
        }

        int r=start/N;
        if(r>=N) return;
        int c=start%N;
        for(int j=c;j<N;j++){
            if(board[r][j]==2){
                bombs.add(new int[]{r,j});
                combi(r*N+j+1,bombCnt+1);
                bombs.remove(bombCnt);
            }
        }
        for(int i=r+1;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==2){
                    bombs.add(new int[]{i,j});
                    combi(i*N+j+1,bombCnt+1);
                    bombs.remove(bombCnt);
                }
            }
        }
    }
    static class Item{
        int r;
        int c;
        Item(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
