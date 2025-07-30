import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2917 {
    static int N,M;
    static char[][] board;
    static boolean[][] visited;
    static int[][] length;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int startR,startC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());

        board=new char[N][M];   visited=new boolean[N][M];  length=new int[N][M];
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        for(int i=0;i<N;i++)
            Arrays.fill(length[i],Integer.MAX_VALUE);

        for(int i=0;i<N;i++){
            String tmp=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=tmp.charAt(j);
                if(board[i][j]=='+'){
                    dq.addFirst(new int[] {i,j,0});
                    length[i][j]=0;
                }
                if(board[i][j]=='V'){
                    startR=i;   startC=j;
                }
            }
        }

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.pollLast();
                for(int j=0;j<4;j++){
                    int curR=item[0]+dr[j]; int curC=item[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<M){
                        if(item[2]+1<length[curR][curC]){
                            length[curR][curC]=item[2]+1;
                            dq.addFirst(new int[]{curR,curC,item[2]+1});
                        }
                    }
                }
            }
        }

        PriorityQueue<Item> pq=new PriorityQueue<>();
        pq.add(new Item(startR,startC,length[startR][startC]));
        visited[startR][startC]=true;
        while(!pq.isEmpty()){
            Item item=pq.poll();
            int maxL=Integer.MIN_VALUE;
            for(int j=0;j<4;j++){
                int curR=item.r+dr[j]; int curC=item.c+dc[j];
                if(curR>=0 && curR<N && curC>=0 && curC<M && !visited[curR][curC]){
                    maxL=Math.max(maxL,length[curR][curC]);
                }
            }
            for(int j=0;j<4;j++){
                int curR=item.r+dr[j]; int curC=item.c+dc[j];
                if((curR>=0 && curR<N && curC>=0 && curC<M && !visited[curR][curC]) && (length[curR][curC]==maxL || length[curR][curC]>=item.length)){
                    pq.add(new Item(curR,curC,Math.min(item.length,maxL)));
                    visited[curR][curC]=true;
                    if(board[curR][curC]=='J'){
                        System.out.println(Math.min(item.length,maxL));
                        return;
                    }
                }
            }
        }



    }
    static class Item implements Comparable<Item>{
        int r;
        int c;
        int length;
        Item(int r,int c,int length){
            this.r=r;
            this.c=c;
            this.length=length;
        }
        public int compareTo(Item i){
            return i.length-this.length;
        }
        public String toString(){
            return r+" "+c+" "+length;
        }
    }
}
