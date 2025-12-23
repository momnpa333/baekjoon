import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int Hr,Hc;
    static int Er,Ec;
    static int[][] maze;
    static int[] dr={1,0,-1,0};
    static int[] dc={0,1,0,-1};
    static ArrayDeque<Item> dq=new ArrayDeque<>();
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        maze=new int[N][M];
        visited=new boolean[2][N][M];

        st = new StringTokenizer(br.readLine(), " ");
        Hr=Integer.parseInt(st.nextToken())-1;
        Hc=Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine(), " ");
        Er=Integer.parseInt(st.nextToken())-1;
        Ec=Integer.parseInt(st.nextToken())-1;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                maze[i][j]=Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(maze[i]));
        }

        dq.add(new Item(Hr,Hc,0));
        visited[0][Hr][Hc]=true;
        if(Hr==Er && Hc==Ec){
            System.out.println(0);
            return;
        }

        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int k=0;k<4;k++){
                    int nextR=item.r+dr[k];
                    int nextC=item.c+dc[k];
                    if(nextR>=0 && nextR<N && nextC>=0 && nextC<M){
                        if(nextR==Er && nextC == Ec){
                            System.out.println(cnt+1);
                            return;
                        }
                        if(maze[nextR][nextC]==0 && !visited[item.bomb][nextR][nextC]){
                            visited[item.bomb][nextR][nextC]=true;
                            dq.add(new Item(nextR,nextC,item.bomb));
                        }
                        if(maze[nextR][nextC]==1 && item.bomb==0){
                            visited[item.bomb+1][nextR][nextC]=true;
                            dq.add(new Item(nextR,nextC,item.bomb+1));
                        }
                    }

                }
            }
            cnt++;
        }
        System.out.println(-1);


    }
    static class Item{
        int r;
        int c;
        int bomb;
        Item(int r,int c,int bomb){
            this.r=r;
            this.c=c;
            this.bomb=bomb;
        }
    }
}