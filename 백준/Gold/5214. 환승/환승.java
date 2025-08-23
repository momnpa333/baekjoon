import java.io.*;
import java.util.*;

public class Main {
    static int N,K,M;
    static int[][] subway;
    static ArrayList<Integer>[] infos;
    static boolean[] visitedS;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visitedS=new boolean[N+1];
        visited=new boolean[M+1];
        subway=new int[M][K];
        infos=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            infos[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<K;j++){
                subway[i][j]=Integer.parseInt(st.nextToken());
                infos[subway[i][j]].add(i);
            }
        }
        ArrayDeque<Item>dq=new ArrayDeque<>();
        dq.add(new Item(1,-1));

        int cnt=0;
        if(N==1){
            System.out.println(1);
            return;
        }
        while(!dq.isEmpty()){
            int L=dq.size();
            cnt++;
//            System.out.println(cnt);
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                visitedS[item.station]=true;
                for(int line:infos[item.station]){
                    if(!visited[line]){
                        if(item.line!=-1)
                            visited[line]=true;
                        for(int j=0;j<K;j++){
                            if(subway[line][j]==N){
                                System.out.println(cnt+1);
                                return;
                            }
                            if(!visitedS[subway[line][j]]){
                                Item newItem=new Item(subway[line][j],line);
                                dq.add(newItem);
                            }
                        }
                    }
                }

            }
        }
        System.out.println(-1);
    }
    static class Item{
        int station;
        int line;
        Item(int station,int line){
            this.station=station;
            this.line=line;
        }
        public String toString(){
            return station+" ";
        }
    }

}
