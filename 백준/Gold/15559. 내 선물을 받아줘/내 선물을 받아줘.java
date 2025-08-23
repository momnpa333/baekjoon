import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] board;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};
    static Item[][] parent;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new char[N][M];
        parent=new Item[N][M];
        check=new boolean[N][M];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j);
                parent[i][j]=new Item(i,j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]=='N'){
                    union(parent[i][j],parent[i-1][j]);
                }
                if(board[i][j]=='E'){
                    union(parent[i][j],parent[i][j+1]);
                }
                if(board[i][j]=='S'){
                    union(parent[i][j],parent[i+1][j]);
                }
                if(board[i][j]=='W'){
                    union(parent[i][j],parent[i][j-1]);
                }
            }
        }
        int answer=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
//                System.out.println(parent[i][j]);
                Item node=findParent(parent[i][j]);
                if(!check[node.r][node.c]){
                    check[node.r][node.c]=true;
//                    System.out.printf("%d %d\n",parent[i][j].r,parent[i][j].c);
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
    static Item findParent(Item node){
        if(node.r==parent[node.r][node.c].r && node.c==parent[node.r][node.c].c){
            return node;
        }
        Item p=findParent(parent[node.r][node.c]);
        node.r=p.r;
        node.c=p.c;
        return node;
    }
    static void union(Item child,Item parent){
        Item A=findParent(child);
        Item B=findParent(parent);
        A.r=B.r;
        A.c=B.c;
    }

    static class Item{
        int r;
        int c;
        Item(int r,int c){
            this.r=r;
            this.c=c;
        }
        public String toString(){
            return r+" "+c;
        }
    }
}
