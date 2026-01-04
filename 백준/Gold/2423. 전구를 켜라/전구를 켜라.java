import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static boolean[][] visited;
    static PriorityQueue<Item> pq;
    static int[][] dr={{0,1,1,0,-1,-1,0},{-1,-1,0,0,0,1,1}};
    static int[][] dc={{1,1,0,0,0,-1,-1},{0,1,1,0,-1,-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j)=='/'?1:0;
            }
//            System.out.println(Arrays.toString(board[i]));
        }
        pq=new PriorityQueue<>();

        int change=0;
        if(board[0][0]==1){
            change++;
            board[0][0]=0;
        }
        if(board[N-1][M-1]==1){
            change++;
            board[N-1][M-1]=0;
        }
        pq.add(new Item(0,0,change,0));
        visited[0][0]=true;

        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(item.r==N-1 && item.c==M-1 && item.op==0){
                System.out.println(item.change);
                return;
            }
            for(int i=0;i<7;i++){
                int nextR=item.r+dr[item.op][i];
                int nextC=item.c+dc[item.op][i];
                if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && !visited[nextR][nextC]){
                    visited[nextR][nextC]=true;
                    int tmp=board[nextR][nextC]==(item.op+i+1)%2?0:1;
                    pq.add(new Item(nextR,nextC, item.change+tmp,(item.op+i+1)%2));
                }
            }
        }
        System.out.println("NO SOLUTION");




    }
    static class Item implements Comparable<Item>{
        int r,c,change,op;
        Item(int r,int c,int change,int op){
            this.r=r;
            this.c=c;
            this.change=change;
            this.op=op;
        }
        public int compareTo(Item o){
            return this.change-o.change;
        }
        public String toString(){
            return r+" "+c+" "+change+" "+op;
        }
    }
}


