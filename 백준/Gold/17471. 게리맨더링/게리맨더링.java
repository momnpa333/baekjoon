import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] humans;
    static final int INF=987654321;
    static int answer=INF;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        humans=new int[N+1];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            humans[i]=Integer.parseInt(st.nextToken());
        }
        graph=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int M=Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++){
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

//        if(!checkAllConnected()) {
//            System.out.println(-1);
//            return;
//        }
        findGap();
        if(answer==INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
    static void findGap(){
        makeArea(new boolean[N+1],1);
    }
    static void makeArea(boolean[] area,int idx){
        if(idx>N) {
            if(isPossible(area)){
                answer=Math.min(findHumansGap(area),answer);
            }
            return;
        }
        makeArea(area,idx+1);
        area[idx]=true;
        makeArea(area,idx+1);
        area[idx]=false;
    }
    static boolean isPossible(boolean[] area){
        int trueNum=0;
        int falseNum=0;
        int trueStart=INF;
        int falseStart=INF;
        for(int i=1;i<=N;i++){
            if(area[i]) {
                trueNum++;
                trueStart=Math.min(trueStart,i);
            }
            if(!area[i]) {
                falseNum++;
                falseStart=Math.min(falseStart,i);
            }
        }
        if(trueNum==N||falseNum==N) return false;

        boolean[] isvisited=new boolean[N+1];
        isvisited[0]=true;
        checkConnected(area,isvisited,true,trueStart);
        checkConnected(area,isvisited,false,falseStart);

        for(int i=1;i<=N;i++){
            if(!isvisited[i]) return false;
        }
        return true;
    }
    static boolean checkAllConnected(){
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        dq.add(1);
        boolean[] visited=new boolean[N+1];
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int item=dq.poll();
                for(int next:graph[item]){
                    if(!visited[next]){
                        visited[next]=true;
                        dq.add(next);
                    }
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    static void checkConnected(boolean[] area,boolean[] isvisited,boolean op,int start){
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        dq.add(start);
        isvisited[start]=true;
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int item=dq.poll();
                for(int next:graph[item]){
                    if(area[next]==op && !isvisited[next]){
                        isvisited[next]=true;
                        dq.add(next);
                    }
                }
            }
        }
    }

    static int findHumansGap(boolean[] area){
        int trueHumans=0;
        int falseHumans=0;
        for(int i=1;i<=N;i++){
            if(area[i]) trueHumans+=humans[i];
            else falseHumans+=humans[i];
        }
        return Math.abs(trueHumans-falseHumans);
    }
}

