import java.io.*;
import java.util.*;

public class Main {
    static int C,R;
    static char[][] maze;
    static int[][] time;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static final int INF=987654321;
    static int startR,startC;
    static int answer=INF;
    static PriorityQueue<Item> pq =new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        C=Integer.parseInt(st.nextToken()); R=Integer.parseInt(st.nextToken());

        maze=new char[R][C];
        time =new int[R][C];
        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                maze[i][j]=s.charAt(j);
                if(maze[i][j]=='T'){
                    startR=i; startC=j;
                    maze[i][j]='0';
                }
            }
        }

        for(int i=0;i<R;i++){
            Arrays.fill(time[i],INF);
        }

        time[startR][startC]=0;

        pq.add(new Item(startR,startC,0));

        while(!pq.isEmpty()){
            int L= pq.size();
            for(int i=0;i<L;i++){
                Item item= pq.poll();
                for(int d=0;d<4;d++){
                    Item next = move(item,d);
                    if(next==null) continue;
                    if(maze[next.r][next.c]=='E'){
                        answer=Math.min(answer,next.time);
                    }
                    if(time[next.r][next.c]>next.time){
                        time[next.r][next.c]=next.time;
                        pq.add(next);
                    }
                }
            }
        }
        if(answer==INF){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);


    }
    static Item move(Item item,int d){
        int curR=item.r; int curC=item.c; int curTime=item.time;
        while(true){
            curR+=dr[d]; curC+=dc[d];
            if(curR<0 || curR>=R || curC<0 || curC>=C){
                return null;
            }
            if(maze[curR][curC]>='0' && maze[curR][curC]<='9') {
                curTime+=maze[curR][curC]-'0';
            }
            if(maze[curR][curC]=='H'){
                return null;
            }
            if(maze[curR][curC]=='R'){
                return new Item(curR-dr[d],curC-dc[d],curTime);
            }
            if(maze[curR][curC]=='E'){
                return new Item(curR,curC,curTime);
            }

        }
    }
    static class Item implements Comparable<Item>{
        int r,c,time;
        Item(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.time=t;
        }
        public int compareTo(Item o){
            return this.time-o.time;
        }
    }
}

