import java.io.*;
import java.util.*;

public class Main {
    static int N,M,oil;
    static int[][] board;
    static Item[][] items;
    static int taxiR,taxiC;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        oil=Integer.parseInt(st.nextToken());

        board=new int[N][N];
        items=new Item[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine()," ");
        taxiR=Integer.parseInt(st.nextToken())-1;
        taxiC=Integer.parseInt(st.nextToken())-1;

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int startR=Integer.parseInt(st.nextToken())-1;
            int startC=Integer.parseInt(st.nextToken())-1;
            int endR=Integer.parseInt(st.nextToken())-1;
            int endC=Integer.parseInt(st.nextToken())-1;

            items[startR][startC]=new Item(startR,startC,endR,endC);
        }

        for(int i=0;i<M;i++){
            Item item=findItem(taxiR,taxiC);
            if(item==null){
                System.out.println(-1);
                return;
            }
//            System.out.printf("%d %d\n",item.startR,item.startC);
//            System.out.println(oil);
            if(!go(item)){
                System.out.println(-1);
                return;
            }
//            System.out.println(oil);
        }
        System.out.println(oil);
    }
    static boolean go(Item item){
        ArrayDeque<int[]>dq=new ArrayDeque<>();
        dq.add(new int[]{item.startR,item.startC});
        boolean[][] visited=new boolean[N][N];
        visited[item.startR][item.startC]=true;

        if(item.startR==item.endR && item.startC==item.endC){
            return true;
        }

        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
            cnt++;
            oil--;
            for(int i=0;i<L;i++){
                int[] pos=dq.poll();
                if(oil<=-1) continue;
                for(int j=0;j<4;j++){
                    int curR=pos[0]+dr[j];
                    int curC=pos[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<N && !visited[curR][curC] && board[curR][curC]!=1){
                        visited[curR][curC]=true;
                        if(curR==item.endR && curC==item.endC){
                            oil+=cnt*2;
                            items[item.startR][item.startC]=null;
                            taxiR=curR; taxiC=curC;
                            return true;
                        }
                        dq.add(new int[]{curR,curC});
                    }
                }
            }
            if(oil<0){
                return false;
            }
        }
        return false;
    }
    static Item findItem(int r,int c){
        ArrayDeque<int[]>dq=new ArrayDeque<>();
        dq.add(new int[]{r,c});
        boolean[][] visited=new boolean[N][N];
        visited[r][c]=true;
        if(items[r][c]!=null){
            return items[r][c];
        }

        PriorityQueue<Item>pq=new PriorityQueue<>();
        while(!dq.isEmpty()){
            int L=dq.size();
            oil--;
            for(int i=0;i<L;i++){
                int[] item=dq.poll();
                if(oil<=-1) continue;
//                System.out.printf("%d %d\n",item[0],item[1]);
                for(int j=0;j<4;j++){
                    int curR=item[0]+dr[j];
                    int curC=item[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<N && !visited[curR][curC] && board[curR][curC]!=1){
                        visited[curR][curC]=true;
                        if(items[curR][curC]!=null){
                            pq.add(items[curR][curC]);
                        }
                        dq.add(new int[]{curR,curC});
                    }
                }
            }
            if(oil<=0) break;
            if(!pq.isEmpty()) break;
        }
//        System.out.println(pq);
        return pq.poll();
    }

    static class Item implements Comparable<Item>{
        int startR;
        int startC;
        int endR;
        int endC;
        Item(int startR,int startC,int endR,int endC){
            this.startR = startR;
            this.startC = startC;
            this.endR = endR;
            this.endC = endC;
        }
        public int compareTo(Item o){
            if(this.startR<o.startR){
                return -1;
            }
            if(this.startR==o.startR){
                if(this.startC<o.startC){
                    return -1;
                }
            }
            return 1;
        }
    }
}
