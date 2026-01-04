import java.io.*;
import java.util.*;

public class Main {
    static int N,L;
    static Set<Integer>[] lines;
    static Set<Integer>[] stationInfos;
    static boolean[] visited;
    static int S,E;
    static Set<Integer> endLines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        lines=new HashSet[L];
        stationInfos=new HashSet[N+1];
        for(int i=0;i<=N;i++){
            stationInfos[i]=new HashSet<>();
        }
        visited=new boolean[L];

        for(int i=0;i<L;i++){
            st=new StringTokenizer(br.readLine()," ");
            lines[i]=new HashSet<>();
            while(true){
                int station=Integer.parseInt(st.nextToken());
                if(station==-1) break;
                lines[i].add(station);
                stationInfos[station].add(i);
            }
        }
        st=new StringTokenizer(br.readLine()," ");
        S=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        endLines=stationInfos[E];

        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int l:stationInfos[S]){
            dq.add(l);
            visited[l]=true;
            if(endLines.contains(l)){
                System.out.println(0);
                return;
            }
        }
        int cnt=0;
        while(!dq.isEmpty()){
            cnt++;
            int L=dq.size();
            for(int i=0;i<L;i++){
                int l=dq.poll();
                for(int nextStation:lines[l]){
                    for(int nextL:stationInfos[nextStation]){
                        if(endLines.contains(nextL)){
                            System.out.println(cnt);
                            return;
                        }
                        if(!visited[nextL]){
                            visited[nextL]=true;
                            dq.add(nextL);
                        }
                    }
                }
            }
        }
        System.out.println(-1);


    }
}
