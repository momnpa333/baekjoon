import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[][] board;
    static int[][][] visited;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        board=new int[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j)-'0';
            }
        }
        visited=new int[K+1][N][M];

        PriorityQueue<Item> pq=new PriorityQueue<>();
        pq.add(new Item(0,0,0,1));
        for(int b=0;b<=K;b++){
            for(int r=0;r<N;r++){
                Arrays.fill(visited[b][r],Integer.MAX_VALUE);
            }
        }
        visited[0][0][0]=1;
        if(N==1 && M==1){
            System.out.println(1);
            return;
        }
        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(item.time>visited[item.bomb][item.r][item.c]){
                continue;
            }

            for(int i=0;i<4;i++){
                int nr=item.r+dr[i];
                int nc=item.c+dc[i];
//                System.out.println(item.r+" "+item.c);
//                System.out.println(nr+" "+nc);
                if(nr==N-1 && nc==M-1){
                    System.out.println(item.time+1);
                    return;
                }
                if(nr>=0 && nr<N && nc>=0 && nc<M){
                    //벽
//                    System.out.println(board[nr][nc]);
                    if(board[nr][nc]==1){
//                        System.out.println("!");
                        //밤
                        if(item.time%2==1 && item.bomb<K && item.time+1<visited[item.bomb+1][nr][nc]){
                            visited[item.bomb+1][nr][nc]=item.time+1;
                            pq.add(new Item(nr,nc, item.bomb+1,item.time+1));
                            continue;
                        }
                        //낮
                        if(item.time%2==0 && item.bomb<K && item.time+2<visited[item.bomb+1][nr][nc]){
                            visited[item.bomb+1][nr][nc]=item.time+2;
                            pq.add(new Item(nr,nc, item.bomb+1,item.time+2));
                            continue;
                        }
                    }
                    //통로
                    if(board[nr][nc]==0){
                        if(item.time+1<visited[item.bomb][nr][nc]){
                            visited[item.bomb][nr][nc]=item.time+1;
                            pq.add(new Item(nr,nc,item.bomb,item.time+1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);

    }
    static class Item implements Comparable<Item>{
        int r,c,bomb,time;
        Item(int r,int c,int bomb,int t){
            this.r=r;
            this.c=c;
            this.bomb=bomb;
            this.time=t;
        }
        public int compareTo(Item o){
            return this.time-o.time;
        }
        public String toString(){
            return r+" "+c+" "+time+" "+bomb;
        }
    }
}