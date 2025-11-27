import java.io.*;
import java.util.*;

public class Main {
    static long[][] dist;
    static int N;
    static Dot[] dots;
    static int[] dx={0,1,0,-1,0};
    static int[] dy={1,0,-1,0,0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        dots=new Dot[N+1];
        for(int i=0;i<=N;i++){
            int x,y;
            st=new StringTokenizer(br.readLine()," ");
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            dots[i]=new Dot(x,y);
        }
        dist=new long[5][N+1];
        for(int j=0;j<5;j++){
            dist[j][1]=calc(dots[0].x,dots[0].y,dots[1].x+dx[j],dots[1].y+dy[j]);
        }
        for(int i=2;i<=N;i++){
            for(int j=0;j<5;j++){
                dist[j][i]=findDist(i,j);
            }
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<5;i++){
//            System.out.println(Arrays.toString(dist[i]));
            ans=Math.min(dist[i][N],ans);
        }
        System.out.println(ans);
    }
    static long findDist(int idx,int op){
        long ret=Long.MAX_VALUE;
        int curX=dots[idx].x+dx[op];
        int curY=dots[idx].y+dy[op];
        for(int i=0;i<5;i++){
            int prevX=dots[idx-1].x+dx[i];
            int prevY=dots[idx-1].y+dy[i];
            long d=calc(curX,curY,prevX,prevY);
            ret=Math.min(dist[i][idx-1]+d,ret);
        }
        return ret;
    }
    static long calc(int x1,int y1,int x2,int y2){
        long ret=0;
//        System.out.println(x1+" "+y1+" "+x2+" "+y2);
        ret+=Math.abs(x1-x2);
        ret+=Math.abs(y1-y2);
//        System.out.println(ret);
        return ret;
    }
    static class Dot{
        int x,y;
        Dot(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}


