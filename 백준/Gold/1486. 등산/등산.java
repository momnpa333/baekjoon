import java.io.*;
import java.util.*;

public class Main {
    static int N,M,T,D;
    static int[][] mountain;
    static int[][] time;
    static int[][] comeBackTime;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int answer;
    static PriorityQueue<Item> pq=new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());

        mountain=new int[N][M];
        time=new int[N][M];
        comeBackTime=new int[N][M];

        for(int i=0;i<N;i++){
            Arrays.fill(time[i],987654321);
        }
        time[0][0]=0;

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                char c=s.charAt(j);
                if(c>='a' && c<='z')
                    mountain[i][j]=c-'a'+26;
                if(c>='A' && c<='Z')
                    mountain[i][j]=c-'A';
            }
//            System.out.println(Arrays.toString(mountain[i]));
        }

//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        pq.add(new Item(0,0,0));
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                comeBackTime[i][j]=makeBack(i,j);
            }
//            System.out.println(Arrays.toString(comeBackTime[i]));
        }

        while(!pq.isEmpty()){
            Item cur=pq.poll();
            if(time[cur.r][cur.c]<cur.time) continue;
            for(int d=0;d<4;d++){
                int nextR=cur.r+dr[d];
                int nextC=cur.c+dc[d];
                int nextT=cur.time+1;
                if(nextR>=0 && nextR<N && nextC>=0 && nextC<M){
                    if(Math.abs(mountain[nextR][nextC]-mountain[cur.r][cur.c])>T) continue;
                    if(mountain[nextR][nextC]>mountain[cur.r][cur.c]){
                        nextT= (int) Math.pow(mountain[nextR][nextC]-mountain[cur.r][cur.c],2)+ cur.time;
                    }
                    if(nextT<=D && nextT<time[nextR][nextC]){
                        time[nextR][nextC]=nextT;
                        pq.add(new Item(nextR,nextC,nextT));
                    }
                }
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(comeBackTime[i][j]+time[i][j]<=D){
                    answer=Math.max(mountain[i][j],answer);
                }
            }
        }
        System.out.println(answer);


    }
    static int makeBack(int r,int c){
        PriorityQueue<Item> pq= new PriorityQueue<>();
        int[][] time=new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(time[i],987654321);
        }
        pq.add(new Item(r,c,0));
        if(r==0 && c==0) return 0;

        while(!pq.isEmpty()){
            Item cur=pq.poll();
            if(time[cur.r][cur.c]<cur.time) continue;
            for(int d=0;d<4;d++){
                int nextR=cur.r+dr[d];
                int nextC=cur.c+dc[d];
                int nextT=cur.time+1;
                if(nextR>=0 && nextR<N && nextC>=0 && nextC<M){
                    if(Math.abs(mountain[nextR][nextC]-mountain[cur.r][cur.c])>T) continue;
                    if(mountain[nextR][nextC]>mountain[cur.r][cur.c]){
                        nextT= (int) Math.pow(mountain[nextR][nextC]-mountain[cur.r][cur.c],2)+ cur.time;
                    }
                    if(nextT<=D && nextT<time[nextR][nextC]){
                        time[nextR][nextC]=nextT;
                        pq.add(new Item(nextR,nextC,nextT));
                    }
                }
            }
        }
        return time[0][0];
    }
    static class Item implements Comparable<Item>{
        int r,c,time;
        public Item(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
        public int compareTo(Item o){
            return this.time-o.time;
        }
    }
}

