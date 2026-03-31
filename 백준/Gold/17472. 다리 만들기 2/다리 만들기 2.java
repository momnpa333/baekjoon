import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int[][] lengths;
    static int nodeL;
    static int[] parent;
    static int answer;
    static PriorityQueue<Item> pq=new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        checkNode();
        lengths=new int[nodeL+1][nodeL+1];
//        printBoard();
        for(int i=1;i<=nodeL;i++){
            for(int j=i+1;j<=nodeL;j++){
                int l=makeBridge(i,j);
                lengths[i][j]=l;
                if(l==987654321) continue;
                pq.add(new Item(l,i,j));
            }
//            System.out.println(Arrays.toString(lengths[i]));
        }
        parent=new int[nodeL+1];
        for(int i=1;i<=nodeL;i++){
            parent[i]=i;
        }

        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(findParent(item.s)!=findParent(item.e)){
                union(item.s,item.e);
                answer+=item.l;
            }
        }
//        System.out.println(Arrays.toString(parent));
        for(int i=1;i<=nodeL;i++){
            if(findParent(i)!=1){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);

    }
    static void union(int a,int b){
        int pA=findParent(a);
        int pB=findParent(b);
        if(pA<pB){
            parent[pB]=pA;
        }
        else{
            parent[pA]=pB;
        }
    }
    static int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node]=findParent(parent[node]);
    }


    static int makeBridge(int s,int e){
        int minL=987654321;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==s){
                    for(int k=0;k<4;k++){
                        int nr=i;
                        int nc=j;
                        int cl=0;
                        while(true){
                            cl++;
                            nr+=dr[k];
                            nc+=dc[k];
                            if(nr<0 || nr>=N || nc<0 || nc>=M) break;
                            if(board[nr][nc]>0 && board[nr][nc]!=e) break;
                            if(board[nr][nc]==e){
                                if(cl-1==1) break;
                                if(cl-1<minL){
                                    minL=cl-1;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return minL;
    }

    static void printBoard(){
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    static void checkNode(){
        boolean[][] visited=new boolean[N][M];
        ArrayDeque<int[]> dq;
        int cnt=1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && board[i][j]==0) {
                    visited[i][j]=true;
                    continue;
                }
                if(!visited[i][j]){
                    visited[i][j]=true;
                    dq=new ArrayDeque<>();
                    dq.add(new int[]{i,j});
                    board[i][j]=cnt;
                    while(!dq.isEmpty()){
                        int[] item=dq.poll();
                        for(int k=0;k<4;k++){
                            int nr=item[0]+dr[k];
                            int nc=item[1]+dc[k];
                            if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && board[nr][nc]!=0){
                                visited[nr][nc]=true;
                                board[nr][nc]=cnt;
                                dq.add(new int[]{nr,nc});
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        nodeL=cnt-1;
    }
    static class Item implements Comparable<Item>{
        int l;
        int s;
        int e;
        Item(int l,int s,int e){
            this.l=l;
            this.s=s;
            this.e=e;
        }
        public int compareTo(Item o){
            return this.l-o.l;
        }
        public String toString(){
            return l+" "+s+" "+e;
        }
    }
}