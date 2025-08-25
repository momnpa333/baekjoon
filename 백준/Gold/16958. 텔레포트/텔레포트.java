import java.io.*;
import java.util.*;

public class Main {
    static int N,T;
    static int[][] dist;
    static City[] cities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        dist=new int[N+1][N+1];
        cities=new City[N+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int op=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            cities[i]=new City(op,x,y);
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                dist[i][j]=Math.abs(cities[i].x-cities[j].x)+Math.abs(cities[i].y-cities[j].y);
                if(cities[i].op==1 && cities[j].op==1){
                    dist[i][j]=Math.min(T,dist[i][j]);
                }

            }
        }

        for(int via=1;via<=N;via++){
            for(int start=1;start<=N;start++){
                for(int end=1;end<=N;end++){
                    if(dist[start][via]+dist[via][end]<dist[start][end]){
                        dist[start][end]=dist[start][via]+dist[via][end];
                    }
                }
            }
        }
        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int S=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            System.out.println(dist[S][E]);
        }

    }
    static class City{
        int op;
        int x;
        int y;
        City(int op,int x,int y){
            this.op=op;
            this.x=x;
            this.y=y;
        }
    }
}
