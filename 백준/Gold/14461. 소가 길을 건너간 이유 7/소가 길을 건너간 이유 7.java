import java.io.*;
import java.util.*;

public class Main {
    static int N,T;
    static int[][] board;
    static PriorityQueue<Item> pq;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int[][][] visit;
    static final int INF=987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        board=new int[N][N];
        visit=new int[3][N][N];

        for(int k=0;k<3;k++){
            for(int i=0;i<N;i++){
                Arrays.fill(visit[k][i],INF);
            }
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        pq=new PriorityQueue<>();
        pq.add(new Item(0,0,0,0));
        visit[0][0][0]=0;

        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(item.t>visit[item.op][item.r][item.c]) continue;
            for(int i=0;i<4;i++){
                int nr=item.r+dr[i];
                int nc=item.c+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<N){
                    int nt=item.t+T;
                    if(item.op==2){
                        nt+=board[nr][nc];
                    }
                    if(nt<visit[(item.op+1)%3][nr][nc]){
                        visit[(item.op+1)%3][nr][nc]=nt;
                        pq.add(new Item(nt,(item.op+1)%3,nr,nc));
                    }
                }
            }
        }
        int answer=INF;
        for(int i=0;i<3;i++){
            answer=Math.min(answer,visit[i][N-1][N-1]);
        }
        System.out.println(answer);
    }
    static class Item implements Comparable<Item>{
        int t;
        int op;
        int r,c;
        Item(int t,int op,int r,int c){
            this.t=t;
            this.op=op;
            this.r=r;
            this.c=c;
        }
        public int compareTo(Item o){
            return this.t-o.t;
        }
        public String toString(){
            return this.r+" "+this.c+" "+this.t;
        }
    }
}
